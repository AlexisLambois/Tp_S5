# Alexis Lambois

## 1

### a)
1) Schema : http, Host : www.univ-lille1.fr, Port : 80, Path : /Accueil/Contacts/Services+étudiants/ 
2) Schema : https, Host : tools.itef.org, Port : 80, Path : /html/rfc3986
3) Schema : http, Host : localhost, Port : 8080, Path : /users/1
4) Schema : https, Host : fr.wikipedia.org, Port : 80, Path : /wiki/Markdown, Fragment : Titres
5) Schema : http, Host : http://traduction.culturecommunication.gouv.fr, Port : 80, Path : /url/Result.aspx, Query : to=en&url=http%3A%2F%2Fwww.culturecommunication.gouv.fr%2F

### b)
http://www.culturecommunication.gouv.fr/

## 2

### a)
1) http://graphql.org/code/ Method : Get

2) http://httpbin.org/post Method : Post, Donnee : foo=bar&toto=tutu

### b)
POST : Création d'une ressource 

## 3

GET /HTTP/1.1
Host: localhost
Accept: */*
If-None-Match: 29cd-53cd739c04ce7

## 4

### a)
curl -v graphql.org/code/

GET HTTP://graphql.org/code/ HTTP/1.1
User-Agent: curl/7.38.0
Host: graphql.org
Accept: */*
Proxy-Connection: Keep-Alive

curl -i graphql.org/code/

HTTP/1.0 200 OK
Server: GitHub.com
Content-Type: text/html; charset=utf-8
Last-Modified: Fri, 23 Feb 2018 19:59:58 GMT
Access-Control-Allow-Origin: *
Expires: Fri, 23 Feb 2018 20:28:14 GMT
Cache-Control: max-age=600
X-GitHub-Request-Id: C7E8:2823:647526:8F8571:5A907704
Content-Length: 53057
Accept-Ranges: bytes
Date: Mon, 05 Mar 2018 08:17:34 GMT
X-Served-By: cache-atl6246-ATL
X-Cache: HIT
X-Cache-Hits: 2
X-Timer: S1520237854.348402,VS0,VE0
Vary: Accept-Encoding
X-Fastly-Request-ID: 443b13f4b2116364f92bf73b73f93a9baee66710
Age: 488
X-Cache: HIT from cacheserv3.univ-lille1.fr
Via: 1.1 varnish, 1.1 cacheserv3.univ-lille1.fr:3128 (squid/2.7.STABLE5-20081024)
Connection: keep-alive
Proxy-Connection: keep-alive

curl -X POST -d "foo=bar&toto=tutu"  httpbin.org/post -v

POST HTTP://httpbin.org/post HTTP/1.1
User-Agent: curl/7.38.0
Host: httpbin.org
Accept: */*
Proxy-Connection: Keep-Alive
Content-Length: 17
Content-Type: application/x-www-form-urlencoded

* upload completely sent off: 17 out of 17 bytes
* HTTP 1.0, assume close after body
HTTP/1.0 200 OK
Server: meinheld/0.6.1
Date: Mon, 05 Mar 2018 08:41:50 GMT
Content-Type: application/json
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true
X-Powered-By: Flask
X-Processed-Time: 0
Content-Length: 461
X-Cache: MISS from cacheserv3.univ-lille1.fr
Via: 1.1 vegur, 1.1 cacheserv3.univ-lille1.fr:3128 (squid/2.7.STABLE5-20081024)
* HTTP/1.0 connection set to keep alive!
Connection: keep-alive
* HTTP/1.0 proxy connection set to keep alive!
Proxy-Connection: keep-alive



