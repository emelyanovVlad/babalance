docker tag vlad110kg/babalance:latest 274796968030.dkr.ecr.eu-north-1.amazonaws.com/babalance:latest
aws ecr get-login-password --region eu-north-1 | docker login --username AWS --password-stdin 274796968030.dkr.ecr.eu-north-1.amazonaws.com/babalance
docker push 274796968030.dkr.ecr.eu-north-1.amazonaws.com/babalance:latest