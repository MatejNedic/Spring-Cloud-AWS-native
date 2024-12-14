How to run an example

run command 

localstack start

After you started Localstack in you local docker env now it is time to put a parameter inside.

You can use following command to do it: 

awslocal ssm put-parameter \
--name "/config/test" \
--value "Value I want to see" \
--type String \
--tags "Key=tag-key,Value=tag-value"



After this was done successfully please run in executable folder ./native to create executable run

mvn -Pnative native:compile

following message should be read:

`message` loaded from the AWS Parameter store: Value I want to see
