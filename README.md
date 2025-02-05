Encurtador de URLs 💻
Este repositório contém um encurtador de URLs desenvolvido com Spring Boot. Com esta ferramenta, você pode converter URLs longas e complexas em links curtos e gerenciáveis, facilitando o compartilhamento e o gerenciamento de links. 🌐

Funcionalidades ✨
Geração de URLs Curtas: Converta URLs longas em links compactos e fáceis de compartilhar. 🔗

Redirecionamento Automático: Links curtos redirecionam automaticamente para os endereços originais. 🔄

Gerenciamento de Links: Visualize e gerencie suas URLs encurtadas de forma intuitiva. 📊

Interface Simples e Responsiva: Frontend desenvolvido com HTML, CSS e JavaScript para uma experiência de usuário agradável. 🎨

Persistência de Dados: Armazenamento seguro e eficiente das URLs no banco de dados PostgreSQL. 🗄️

Tecnologias Utilizadas 🛠️
Backend: Spring Boot (Java)

Frontend: HTML, CSS, JavaScript

Banco de Dados: PostgreSQL

Templates: Thymeleaf (para renderização de páginas HTML no servidor)

Containerização: Docker e Docker Compose (para facilitar a implantação e o gerenciamento de ambientes)

Como Usar 🚀
Pré-requisitos
Docker e Docker Compose instalados na sua máquina.

Conexão com a internet para baixar as imagens dos containers.

Passos para Executar o Projeto
Clone o repositório:

bash
Copy
git clone https://github.com/KayoLeanndro/Encurta-Url.git
cd Encurta-Url
Suba os containers com Docker Compose:

bash
Copy
docker-compose up --build
Isso irá:

Construir a imagem da aplicação Spring Boot.

Configurar o banco de dados PostgreSQL.

Iniciar a aplicação e o banco de dados em containers.

Acesse a aplicação:
Abra o navegador e acesse:

Copy
http://localhost:8085
Use o encurtador de URLs:

Insira uma URL longa no campo designado.

Gere um link curto e compartilhe!

Acesse o link curto para ser redirecionado automaticamente para a URL original.

Estrutura do Projeto 📂
Copy
Encurta-Url/
├── src/                  # Código-fonte da aplicação Spring Boot
│   ├── main/
│   │   ├── java/         # Lógica do backend (controllers, services, etc.)
│   │   ├── resources/    # Configurações, templates Thymeleaf e arquivos estáticos
│   │   └── webapp/       # Frontend (HTML, CSS, JS)
├── docker/               # Configurações do Docker
├── docker-compose.yml    # Configuração do Docker Compose
├── README.md             # Este arquivo
└── pom.xml               # Dependências do projeto (Maven)

Contribuição 🤝
Contribuições são bem-vindas! Siga os passos abaixo:

Faça um fork do repositório.

Crie uma branch para sua feature (git checkout -b feature/nova-feature).

Commit suas mudanças (git commit -m 'Adicionando nova feature').

Push para a branch (git push origin feature/nova-feature).

Abra um Pull Request.

Licença 📜
Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.

Contato 📧
Se tiver dúvidas ou sugestões, entre em contato:

Autor: Kayo Leanndro

GitHub: KayoLeanndro

