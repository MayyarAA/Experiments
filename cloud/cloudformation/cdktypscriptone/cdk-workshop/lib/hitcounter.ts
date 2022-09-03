import * as cdk from 'aws-cdk-lib';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import * as dynamodb from 'aws-cdk-lib/aws-dynamodb';
import { Construct } from 'constructs';
import { table } from 'console';

export interface HitCounterProps {
	/** the function for which we want to count url hits **/
	downstream: lambda.IFunction; //defining the type of the variable downstream
}

export class HitCounter extends Construct {
	public readonly handler: lambda.Function;
	//defining types of the args passed to HitCounter constructor
	constructor(scope: Construct, id: string, props: HitCounterProps) {
		super(scope, id);

		//define the Hits table, require partitionKey
		const table = new dynamodb.Table(this, 'Hits', {
			partitionKey: { name: 'path', type: dynamodb.AttributeType.STRING },
			removalPolicy: cdk.RemovalPolicy.DESTROY,
		});
		//wired the Lambda’s environment variables to the functionName and tableName of our resources.
		this.handler = new lambda.Function(this, 'HitCounterHandler', {
			runtime: lambda.Runtime.NODEJS_14_X,
			handler: 'hitcounter.handler',
			code: lambda.Code.fromAsset('lambda'),
			environment: {
				DOWNSTREAM_FUNCTION_NAME: props.downstream.functionName,
				HITS_TABLE_NAME: table.tableName,
			},
		});
		// grant the lambda role read/write permissions to our table
		table.grantReadWriteData(this.handler);

		// grant the lambda role invoke permissions to the downstream function
		props.downstream.grantInvoke(this.handler);
	}
}
