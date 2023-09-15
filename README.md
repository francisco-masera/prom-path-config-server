# Config Server
## Como correr el proyecto
### Requisitos
1. Docker instalado
2. Kubernetes instalado (en este caso usaremos minikube)
3. Java JDK 11+ instalado

### Ambientando K8S

1.  Crear secreto para tener acceso al container registry para lo cual corremos el siguiente comando 

        kubectl create secret docker-registry regcred --docker-server=ghcr.io --docker-username=github-user --docker-password=github-token --docker-email=email

### Levantando el vault
