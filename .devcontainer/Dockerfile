FROM foobarxyzzy/sbt:1.3.10-openjdk13-alpine3.10

ARG USER
ARG HOME

RUN apk add --update --no-cache \ 
        git \
        curl \
        bash \
        openssh-client \
        ca-certificates 

# docker
RUN apk add --no-cache docker \
# docker-compose
 && apk add --no-cache python3 \
 && apk add --no-cache --virtual .to-build-docker-compose \
        python3-dev \
        gcc \
        make \
        libc-dev \
        libffi-dev \
        openssl-dev \
 && python3 -m ensurepip \
 && pip3 --no-cache-dir install --upgrade pip \
 && pip3 --no-cache-dir install docker-compose \
 && apk del .to-build-docker-compose

RUN adduser -S ${USER} -h ${HOME} \
 && echo "${USER} ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

USER ${USER}