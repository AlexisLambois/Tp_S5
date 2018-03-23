FROM nginx:latest
ENV http_proxy 'http://cache-etu.univ-lille1.fr:3128'
COPY index.html /usr/share/nginx/html
RUN chmod go+rX -R /usr/share/nginx/html
EXPOSE 8080