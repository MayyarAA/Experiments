import { Duration, Stack, StackProps } from 'aws-cdk-lib';
import * as sns from 'aws-cdk-lib/aws-sns';
import * as subs from 'aws-cdk-lib/aws-sns-subscriptions';
import * as sqs from 'aws-cdk-lib/aws-sqs';
import * as cdk from 'aws-cdk-lib';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import { Construct } from 'constructs';

export class CdkWorkshopStack extends Stack {
	constructor(scope: Construct, id: string, props?: StackProps) {
		super(scope, id, props);
		//define a new aws lambda fnc resources
		const hello = new lambda.Function(this, 'HelloHandler', {
			runtime: lambda.Runtime.NODEJS_14_X, // execution environment
			code: lambda.Code.fromAsset('lambda'), // code loaded from "lambda" directory
			handler: 'hello.handler', // file is "hello", function is "handler"
		});
	}
}

// const queue = new sqs.Queue(this, 'CdkWorkshopQueue', {
// 	visibilityTimeout: Duration.seconds(300),
// });

// const topic = new sns.Topic(this, 'CdkWorkshopTopic');
// //subs queue to messages pushed under that topic in sns
// topic.addSubscription(new subs.SqsSubscription(queue));
