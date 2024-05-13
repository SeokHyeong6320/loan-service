#!/bin/zsh

# Setting versions
VERSION='1.0.0'

cd ..
./gradle clean build -x test

ROOT_PATH=`pwd`
echo $ROOT_PATH

echo 'docker Image build...'
cd $ROOT_PATH && docker build -t loan-service:$VERSION .
echo 'docker Image build... Done'
