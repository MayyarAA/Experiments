import { Duration, Stack, StackProps } from 'aws-cdk-lib';
import * as sns from 'aws-cdk-lib/aws-sns';
import * as subs from 'aws-cdk-lib/aws-sns-subscriptions';
import * as sqs from 'aws-cdk-lib/aws-sqs';
import * as cdk from 'aws-cdk-lib';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import * as apigw from 'aws-cdk-lib/aws-apigateway';
import { Construct } from 'constructs';
import { HitCounter } from './hitcounter';
export class CdkWorkshopStack extends Stack {
	constructor(scope: Construct, id: string, props?: StackProps) {
		super(scope, id, props);
		//define a new aws lambda fnc resources
		//lambda construct(scope, id, props)
		const hello = new lambda.Function(this, 'HelloHandler', {
			runtime: lambda.Runtime.NODEJS_14_X, // execution environment
			code: lambda.Code.fromAsset('lambda'), // code loaded from "lambda" directory
			handler: 'hello.handler', // file is "hello", function is "handler"
		});
		const helloWithCounter = new HitCounter(this, 'HelloHitCounter', {
			downstream: hello,
		});

		// defines an API Gateway REST API resource backed by our "hello" function.
		new apigw.LambdaRestApi(this, 'Endpoint', {
			//actual defining the lambda fnc object as resource mapped
			handler: helloWithCounter.handler, // mapping the lambda fnc that will handle api-gateway req
		});
	}
}

// const queue = new sqs.Queue(this, 'CdkWorkshopQueue', {
// 	visibilityTimeout: Duration.seconds(300),
// });

// const topic = new sns.Topic(this, 'CdkWorkshopTopic');
// //subs queue to messages pushed under that topic in sns
// topic.addSubscription(new subs.SqsSubscription(queue));
