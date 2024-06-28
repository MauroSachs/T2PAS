# Arquitetura do Projeto

Este projeto foi desenvolvido seguindo os princípios da arquitetura Clean Architecture, uma abordagem de design de software que promove a separação clara e estruturada das responsabilidades em diferentes camadas.

## Clean Architecture Overview

A arquitetura Clean Architecture é composta por três camadas principais, cada uma com um propósito específico:

### 1. Camada de Domínio (Domain)

A camada de Domínio é a mais interna e fundamental da arquitetura. Ela contém as regras de negócio centrais da aplicação e é onde as entidades do domínio são definidas. Dentro desta camada, encontramos:

- **Entidades (Entities)**: Representam os objetos principais do domínio da aplicação.
- **Repositórios (Repositories)**: Interfaces que definem contratos para operações de persistência, permitindo a comunicação com a camada de dados.
- **Serviços (Services)**: Implementam as regras de negócio da aplicação e orquestram as interações entre as entidades e os repositórios.

### 2. Camada de Aplicação (Application)

A camada de Aplicação é responsável por orquestrar as regras de negócio definidas na camada de Domínio e coordenar as interações entre as diferentes partes da aplicação. Nesta camada, encontramos:

- **Casos de Uso (Use Cases)**: Implementações concretas dos cenários de uso da aplicação, utilizando os serviços da camada de Domínio para realizar as operações necessárias.
- **DTOs (Data Transfer Objects)**: Classes que representam os dados transferidos entre as diferentes camadas da aplicação.

### 3. Camada de Adaptadores (Adapter)

A camada de Adaptadores é a mais externa e lida com as interações da aplicação com o mundo exterior, como interfaces de usuário e bancos de dados. Ela adapta as interfaces externas para serem compatíveis com os requisitos internos da aplicação. Nesta camada, temos:

- **Controladores (Controllers)**: Recebem e respondem às requisições HTTP, chamando os casos de uso da camada de Aplicação conforme necessário.
- **Implementações de Repositórios (Repositories)**: Classes concretas que implementam os contratos definidos na camada de Domínio, lidando com a persistência de dados.
- **Modelos (Models)**: Representam as entidades de banco de dados específicas para a persistência de dados.
- **Fontes de Dados (Datasources)**: Classes responsáveis pela comunicação direta com o banco de dados.

Aplicativo Controller:
 POST /servcad/aplicativos - create
 GET /servcad/aplicativos - listarTodos
 GET /servcad/aplicativos/{id} - getById
 POST /servcad/aplicativos/atualizacusto/{id} - atualizaCusto
 PATCH /servcad/aplicativos/{id} - alterar

AssinaturaAplicativo Controller
 POST /servcad/assapp/{idAplicativo} - listarClientesAssinados

AssinaturaCliente Controller
GET /servcad/asscli/{idCliente} - listarPorCliente

Assinatura Controller
POST /servcad/assinaturas - assinar
GET /servcad/assinaturas - listarTodos
GET /servcad/assinaturas/{tipo} - listarPorTipo

AssinaturaValida Controller
GET /assinvalida/{idAssinatura} - validarAssinatura

Cliente Controller
POST /servcad/clientes - create
GET /servcad/clientes - listarTodos
PATCH /servcad/clientes/{id} - alterar

Pagamento Controller
POST /registrarpagamento - create
*/