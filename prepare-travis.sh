#!/bin/bash
#arg 1: username/repo
#arg 2: password
travis login --github-token 54a0fb9f2ee7e2bb079be9b8ff6d8736dba05b65
travis enable -r $1

export ENCRYPTION_PASSWORD=chichi123*
openssl aes-256-cbc -pass pass:$ENCRYPTION_PASSWORD -in ~/.gnupg/trustdb.gpg -out deploy/secring.gpg.enc
openssl aes-256-cbc -pass pass:$ENCRYPTION_PASSWORD -in ~/.gnupg/pubring.kbx -out deploy/pubring.kbx.enc

travis encrypt --add -r $1 SONATYPE_USERNAME=vegegoku
travis encrypt --add -r $1 SONATYPE_PASSWORD=chichi123*
travis encrypt --add -r $1 ENCRYPTION_PASSWORD=chichi123*
travis encrypt --add -r $1 GPG_KEYNAME=78549437
travis encrypt --add -r $1 GPG_PASSPHRASE=chichi123*
