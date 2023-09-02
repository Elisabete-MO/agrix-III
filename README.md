# :construction: README customizado em construção ! :construction:
<!-- A Fase B do projeto foi um sucesso! Sua equipe agora ficou responsável por expandir a aplicação e incluir algumas funcionalidades extra. Inclusive, vocês receberam uma base de código pronta que conseguiram adquirir de outra empresa, e que precisará ser testado.

Por que isso é importante?
Na vida de uma pessoa desenvolvedora é muito frequente a necessidade de trabalhamos com persistência de dados e com testes. Em primeiro lugar, este projeto te permitirá colocar em prática os conhecimentos sobre persistência com Spring Data e sobre testes que adquiriu durante a seção.

Mas para além disso, ele também te dará a oportunidade de exercitar suas habilidades na definição da arquitetura de um projeto. Este projeto foi desenvolvido focando no comportamento da sua aplicação, sem restringir tanto a forma com que ele será construído e implementado. Por isso, você terá maior liberdade (e responsabilidade) nas decisões de como estruturá-lo.

A capacidade de pensar e decidir como estruturar uma solução é algo muito valioso para uma pessoa programadora. Então vamos praticar!

Especificação
O que vamos avaliar?
Qualidade de código (“linter”)
Comportamento dos endpoints da API
Cobertura de código
O que devo desenvolver?
Neste projeto, verificamos se você é capaz de:

Aplicar o conhecimento do ecossistema Spring para criar rotas da API.
Aplicar a injeção de dependência para conectar as camadas de controle, serviço e persistência.
Utilizar o Spring Data JPA para implementar entidades e repositórios para a persistência em banco de dados, bem como implementar buscas customizadas.
Utilizar o Spring Security para implementar autenticação e autorização de pessoas usuárias.
Utilizar campos de data nas rotas da API e no banco de dados.
Atenção ⚠️: Leia o arquivo README.md do projeto com atenção para uma explicação detalhada de como desenvolver e entregar seu projeto.

Entregáveis
Para entregar o seu projeto, você deverá criar um Pull Request para um repositório no GitHub, seguindo as especificações detalhadas no README.md do projeto. Consulte o canal do Slack da turma para obter o endereço do repositório.

Combinados
Atente-se as instruções no README.md do repositório!
Qualquer dúvida, poste no Slack.
Lembre-se: você pode consultar nosso conteúdo sobre Git & GitHub na plataforma de aprendizagem quando quiser!


# `Projeto Final - Agrix - Fase C`

Boas-vindas ao repositório do projeto `Projeto Final - Agrix - Fase C`

Para realizar o projeto, atente-se a cada passo descrito a seguir e se tiver **qualquer dúvida**,
nos envie no _Slack_ da turma! #vqv 🚀

Aqui, você vai encontrar os detalhes de como estruturar o desenvolvimento do seu projeto a partir
desse repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

## Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes
do [Código de Conduta e do Manual da Pessoa Estudante da Trybe](https://app.betrybe.com/learn/student-manual/codigo-de-conduta-da-pessoa-estudante).

## Entregáveis

<details>
  <summary>🤷🏽‍♀️ Como entregar</summary><br />

Para entregar o seu projeto, você deverá criar um _Pull Request_ neste repositório.

Lembre-se que você pode consultar nosso conteúdo
sobre [Git & GitHub](https://app.betrybe.com/learn/course/5e938f69-6e32-43b3-9685-c936530fd326/module/fc998c60-386e-46bc-83ca-4269beb17e17/section/fe827a71-3222-4b4d-a66f-ed98e09961af/day/1a530297-e176-4c79-8ed9-291ae2950540/lesson/2b2edce7-9c49-4907-92a2-aa571f823b79)
e nosso [Blog - Git & GitHub](https://blog.betrybe.com/tecnologia/git-e-github/) sempre que
precisar!
</details>

<details>
  <summary>👨‍💻 O que deverá ser desenvolvido</summary><br />

Chegamos à Fase C do projeto Agrix! Agora que temos um projeto funcional, precisamos começar a nos preocupar com aspectos de segurança. Vamos lá!
</details>

<details>
  <summary><strong>📝 Habilidades a serem trabalhadas</strong></summary>

Neste projeto, verificamos se você é capaz de:

- Aplicar o conhecimento sobre Spring Security para adicionar autenticação ao projeto.
- Garantir que diferentes rotas atenda a regras específicas de autorização. 

</details>

<details>
<summary><strong>🗓 Data de Entrega</strong></summary>

- Este projeto é individual
- Serão `X` dias de projeto
- Data de entrega para avaliação regular do projeto: `dd/mm/yyyy - 14:00h`

</details>

## Orientações

<details>

   <summary><strong>‼ Antes de começar a desenvolver </strong></summary>

1. Clone o repositório

- Use o comando: `git clone <url do repositório>`
- Entre na pasta do repositório que você acabou de clonar:
    - `cd <nome do repositório>`

2. Instale as dependências

- `mvn install -DskipTests`

3. Crie uma branch a partir da branch `main`

- Verifique que você está na branch `main`
    - Exemplo: `git branch`
- Se você não estiver, mude para a branch `main`
    - Exemplo: `git checkout main`
- Agora, crie uma branch à qual você vai submeter os `commits` do seu projeto:
    - Você deve criar uma branch no seguinte formato: `nome-sobrenome-nome-do-projeto`;
    - Exemplo: `git checkout -b maria-soares-lessons-learned`

4. Crie na raiz do projeto os arquivos que você precisará desenvolver:

- Verifique que você está na raiz do projeto:
    - Exemplo: `pwd` -> o retorno vai ser algo tipo
      _/Users/maria/code/**sd-0x-project-lessons-learned**_
- Crie os arquivos index.html e style.css:
    - Exemplo: `touch index.html style.css`

5. Adicione as mudanças ao _stage_ do Git e faça um `commit`

- Verifique que as mudanças ainda não estão no _stage_:
    - Exemplo: `git status` (devem aparecer listados os novos arquivos em vermelho)
- Adicione o novo arquivo ao _stage_ do Git:
    - Exemplo:
        - `git add .` (adicionando todas as mudanças - _que estavam em vermelho_ - ao stage do Git)
        - `git status` (devem aparecer listados os arquivos em verde)
- Faça o `commit` inicial:
    - Exemplo:
        - `git commit -m 'iniciando o projeto. VAMOS COM TUDO :rocket:'` (fazendo o primeiro commit)
        - `git status` (deve aparecer uma mensagem tipo _nothing to commit_ )

6. Adicione a sua branch com o novo `commit` ao repositório remoto

- Usando o exemplo anterior: `git push -u origin maria-soares-lessons-learned`

7. Crie um novo `Pull Request` _(PR)_

- Vá até a página de _Pull Requests_
  do [repositório no GitHub](https://github.com/tryber/sd-0x-project-lessons-learned/pulls)
    - Clique no botão verde _"New pull request"_
    - Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
- Coloque um título para o seu _Pull Request_
    - Exemplo: _"Cria tela de busca"_
- Clique no botão verde _"Create pull request"_

- Adicione uma descrição para o _Pull Request_, um título nítido que o identifique, e clique no
  botão verde _"Create pull request"_

 <img width="1335" alt="Exemplo de pull request" src="https://user-images.githubusercontent.com/42356399/166255109-b95e6eb4-2503-45e5-8fb3-cf7caa0436e5.png">

- Volte até a [página de _Pull
  Requests_ do repositório](https://github.com/tryber/sd-0x-project-lessons-learned/pulls) e confira
  que o seu _Pull Request_ está criado

</details>

<details>

<summary><strong>⌨️ Durante o desenvolvimento</strong></summary>

Faça `commits` das alterações que você fizer no código regularmente, pois assim você garante
visibilidade para o time da Trybe e treina essa prática para o mercado de trabalho :) ;

- Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto;
- Os comandos que você utilizará com mais frequência são:
    - `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde -
      no stage)_;
    - `git add` _(para adicionar arquivos ao stage do Git)_;
    - `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_;
    - `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na
      primeira vez que fizer o `push` de uma nova branch)_;
    - `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_.

</details>

<details>
<summary><strong>🎛 Checkstyle</strong></summary>

Para garantir a qualidade do código, vamos utilizar neste projeto o `Checkstyle`. Assim o código
estará alinhado com as boas práticas de desenvolvimento, sendo mais legível e de fácil manutenção!
Para poder rodar o `Checkstyle` certifique-se de ter executado o comando `mvn install` dentro do
repositório.

Para rodá-los localmente no repositório, execute os comandos abaixo:

```bash
mvn checkstyle:check
```

Se a análise do `Checkstyle` encontrar problemas no seu código, tais problemas serão mostrados no
seu terminal. Se não houver problema no seu código, nada será impresso no seu terminal.

Você pode também instalar o plugin do `Checkstyle` na sua `IDE`. Para isso, volte na primeira seção
do conteúdo.

⚠️ **PULL REQUESTS COM ISSUES NO `Checkstyle` NÃO SERÃO AVALIADAS. ATENTE-SE PARA RESOLVÊ-LAS ANTES
DE FINALIZAR O DESENVOLVIMENTO!** ⚠️

</details>

<details>
<summary><strong>🛠 Testes</strong></summary>

Para executar todos os testes basta rodar o comando:

```bash
mvn test
```

Para executar apenas uma classe de testes:

```bash
mvn test -Dtest="TestClassName"
```

</details>

## Especificações do projeto

<details>
<summary> ⚠️ Informações sobre como implementar os requisitos</summary><br>

Os testes deste projeto são, de maneira geral, testes de integração. Cada teste fará diversas chamadas à sua API e validará a resposta e o comportamento da aplicação, mas sem restringir implementações específicas de classes e métodos.

Por isso, neste projeto você terá maior liberdade para estruturar e implementar sua aplicação da forma que escolher, desde que atenda aos requisitos pedidos e algumas especificações que serão explicadas aqui.

Uma das restrições é que o projeto deve ser implementado utilizando o ecossistema Spring (Spring Boot, Spring Web, Spring Data, etc). Você pode utilizar outras bibliotecas e ferramentas se desejar, mas garanta que elas são compatíveis com o Spring e com os testes do projeto.
</details>

<details>
<summary>🗄️ Descrição do banco de dados</summary><br>

O banco de dados continua com o diagrama da Fase B:

![Modelo de tabelas](images/agrix-tabelas-fase-b.png)

Nesse modelos, temos as seguintes tabelas:
- `farm`: representa uma fazenda
- `crop`: representa uma plantação, e está em relacionamento `n:1` ("muitos para um") com a tabela `farm`
  - Esta tabela recebeu alguns campos a mais, que guardam datas, e que precisarão ser considerados durante o desenvolvimento da Fase B.
- `fertilizer`: esta nova tabela representa um fertilizante, e está em um relacionamento `n:n` ("muitos para muitos") com a tabela `crop`. Esse relacionamento é realizado através da tabela `crop_fertilizer`.

A diferença agora é que precisamos integrar o código para controle de pessoas ao restante da nossa aplicação.

Alguns elementos importantes a considerar sobre a implementação da camada de persistência e do banco de dados:
- Apesar do nome das tabelas e colunas (com seus tipos) não precisarem ser exatamente esses, os testes do projeto chamarão sua API usando requisições e esperam respostas baseados nesse modelo.
- Os testes do projeto não esperam um banco de dados específico. No entanto, sugerimos que você utilize o MySQL como banco de dados.
- Os testes do projeto utilizam um banco "mockado" em memória do tipo H2. Isso não deve afetar sua implementação, mas tome cuidado ao utilizar funcionalidades muito específicas de um determinado tipo de banco de dados e que não sejam compatíveis com os testes.
</details>

<details>
<summary>🏛️ Arquitetuda da aplicação</summary><br>

Como dito, neste projeto você terá maior liberdade para escolher como vai estruturar e implementar sua aplicação. Algumas dicas e recomendações:

- O projeto não possui uma estrutura pré-definida de pacotes (com algumas exceções). Ainda assim, recomendamos que você cuide para ter uma boa organização e divisão de pacotes. Na dúvida, se inspire no que você viu no conteúdo ou nos projetos anteriores.
- Da mesma maneira, não há exigência de uma arquitetura específica de camadas. No entanto, uma boa arquitetura pode ajudar a garantir não só uma maior qualidade de código, como também facilitar para você realizar manutenção e aprimoramentos posteriormente.
- Sugerimos que você considere utilizar os padrões e boas práticas que tem visto no conteúdo, aulas e projetos. Mas sinta-se à vontade também para estudar e pensar em como pode melhorar e expandir a forma com que estrutura seu código.

Por fim, a mensagem que deixamos é: aproveite a oportunidade para desenvolver mais sua capacidade de estruturar e construir uma aplicação!

</details>

## Requisitos

### 1. Migre seu código da Fase B para este projeto (Fase C)

<details>
  <summary>Migre seu código que implementou no "Agrix - Fase B" para este projeto (Fase C)</summary><br />

Neste requisito, você deverá trazer todo o código que você implementou durante o "Agrix - Fase B" para este projeto (Agrix - Fase C).

Tome cuidado especial com:
 - `pom.xml`: o `pom.xml` inicial das Fase C não é igual ao `pom.xml` da Fase B, então você não pode simplesmente substituílo. Cuide para transferir apenas as dependências que você incluiu, sem alterar as outras configurações do projeto.
 
Durante os testes deste requisito, serão validadas as seguintes rotas:
 - GET `/farms`
 - GET `/crops`
 - GET `/fertilizers`

Você precisará trazer todo o código que você implementou na fase anterior para conseguir finalizar esta fase.

</details>

### 2. Crie a rota POST /persons

<details>
  <summary>Crie a rota POST /persons para salvar novas pessoas no banco</summary><br />

Neste requisito você vai criar uma rota para integrar a API com o código que foi adquirido e testado na fase anterior, localizado no pacote `com.betrybe.agrix.ebytr.staff`.

Se quiser, nesta fase você já pode refatorar o código desse pacote e mover ele para seguir a organização do restante da sua aplicação.

A definição da rota é:
- `/persons` (`POST`)
    - deve receber no corpo da requisição:
      - `username`
      - `password`
      - `roles` (conforme definido no enum `Role`, disponibilizado com o código)
    - deve criar a pessoa com os dados passados
    - deve responder com os campos `id`, `username` e `role` (mas não `password`)

<details>
  <summary>🔍 Formato/exemplo de requisição e resposta</summary><br />

Exemplo de requisição na rota POST `/persons`:

```json
{
  "username": "zerocool",
  "password": "senhasecreta",
  "role": "ADMIN"
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "username": "zerocool",
  "role": "ADMIN"
}
```

</details>

</details>

### 3. Adicione autenticação no projeto

<details>
  <summary>Adicione autenticação no projeto, incluindo uma rota para login que retorna um JWT</summary><br />

Neste requisito você deverá configurar o Spring Security e implementar no seu projeto a autenticação por usuário e senha.

Você deverá:
1. Garantir acesso público (ou seja, desprotegido) aos endpoints:
    - POST `/persons` (criado acima, para permitir cadastro de novas pessoas)
    - POST `/auth/login` (será criado abaixo, para permitir login) 
2. Criar a rota POST `/auth/login`:
    - deve receber o `username` e `password` no corpo da requisição
    - deve validar os dados passados utilizando as pessoas que foram criadas pela rota `/persons`
    - caso os dados estejam incorretos, deve retornar status 403
    - caso os dados estejam corretos, deve retornar um campo `token` contendo um JWT gerado

<details>
  <summary>🔍 Formato/exemplo de requisição e resposta</summary><br />

Exemplo de requisição na rota POST `/auth/login` (suppondo que os dados estejam corretos):

```json
{
  "username": "zerocool",
  "password": "senhasecreta"
}
```

Exemplo de resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZ3JpeCIsInN1YiI6Im1ycm9ib3QiLCJleHAiOjE2ODk5ODY2NTN9.lyha4rMcMhFd_ij-farGCXuJy-1Tun1IpJd5Ot6z_5w"
}
```

</details>

</details>

### 4. Limitar acesso à rota GET /farms

<details>
  <summary>Limitar acesso à rota GET /farms para pessoa autenticada com role correto</summary><br />

Neste requisito você deve limitar o acesso à rota GET `/farms` para que apenas uma pessoa autenticada com role `USER`, `MANAGER` ou `ADMIN` possa acessar.

Você deve retornar status 403 caso a pessoa não tenha permissões corretas. Do contrário, a rota deve retornar a resposta usual.

</details>

### 5. Limitar acesso à rota GET /crops

<details>
  <summary>Limitar acesso à rota GET /crops para pessoa autenticada com role correto</summary><br />

Neste requisito você deve limitar o acesso à rota GET `/crops` para que apenas uma pessoa autenticada com role `MANAGER` ou `ADMIN` possa acessar.

Você deve retornar status 403 caso a pessoa não tenha permissões corretas. Do contrário, a rota deve retornar a resposta usual.

</details>

### 6. Limitar acesso à rota GET /fertilizers

<details>
  <summary>Limitar acesso à rota GET /fertilizers para pessoa autenticada com role correto</summary><br />

Neste requisito você deve limitar o acesso à rota GET `/fertilizers` para que apenas uma pessoa autenticada com role `ADMIN` possa acessar.

Você deve retornar status 403 caso a pessoa não tenha permissões corretas. Do contrário, a rota deve retornar a resposta usual.

</details>

---

<details>
<summary><strong>🗣 Nos dê feedbacks sobre o projeto!</strong></summary>

Ao finalizar e submeter o projeto, não se esqueça de avaliar sua experiência preenchendo o
formulário.
**Leva menos de 3 minutos!**

[Formulário de avaliação do projeto](https://be-trybe.typeform.com/to/ZTeR4IbH)

</details>

<details>
<summary><strong>🗂 Compartilhe seu portfólio!</strong></summary>

Você sabia que o LinkedIn é a principal rede social profissional e compartilhar o seu aprendizado lá
é muito importante para quem deseja construir uma carreira de sucesso? Compartilhe esse projeto no
seu LinkedIn, marque o perfil da Trybe (@trybe) e mostre para a sua rede toda a sua evolução.

</details>

---

<!-- mdi versão 1.1 projeto ⚠️ não exclua esse comentário -->


-->
