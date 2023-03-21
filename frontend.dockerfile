## FRONTEND ##
FROM node:alpine AS builder

WORKDIR /app

COPY ./src/main/fe/angularclient/ .

RUN npm install && \
    npm run build

FROM nginx:alpine

COPY --from=builder /app/dist/* /usr/share/nginx/html/
COPY src/main/fe/angularclient/nginx.conf /etc/nginx/conf.d/default.conf