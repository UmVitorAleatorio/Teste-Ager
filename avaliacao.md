# SOC - Avaliação Dev 

## _Projeto de avaliação para desenvolvedores Java_    

Consiste em um sistema de Cadastro de Exames, no qual o usuário deverá cadastrar novos exames, consultar as informações e obter acesso a informações através de web services.

## Conteúdo do Projeto

- Crud parcial de Exames ( Inserção e busca ).
- WS Soap para busca de exame.


## Tecnologias utilizadas

O projeto tem como base as tecnologias descritas abaixo:


| Tecnologias | README |
| ------ | ------ |
| ![][eclipse] | https://www.eclipse.org/downloads/ |
| ![][java8] | https://docs.oracle.com/javase/8/docs/ |
| ![][maven] | https://maven.apache.org/guides/ |
| ![][struts] | https://struts.apache.org/getting-started/ |
| ![][bootstrap5] | https://getbootstrap.com/docs/5.0/getting-started/introduction/ |
| ![][h2] | http://www.h2database.com/html/tutorial.html |
| ![][jetty] | https://www.eclipse.org/jetty/ |
| ![][git] | https://git-scm.com/ |
| ![][soap] | https://docs.oracle.com/javase/7/docs/api/javax/xml/soap/package-summary.html |


## Instalação

**Pré-Requisito:**

Tenha o Java 8 instalado em sua máquina. Em caso de dúvidas, entre no link abaixo:

- [Guia de instalações JDK 8]

Efetue o download da última versão do eclipse, no link abaixo:

- [Download do eclipse aqui]

Efetue o download e instalação do GIT e GIT Bash, no link abaixo. Caso desejar, poderá utilizar uma ferramenta client para gerenciar o GIT, recomendados o uso do GIT Tortoise:

- [Download do GIT aqui]
- (Opcional) [Download do GIT Tortoise aqui]

Recomendamos a ferramenta SoapUI para efetuar os testes de Web Service:

- [Download do SoapUI aqui]


##
##
**Acessando o projeto:**

Os passos abaixo descrevem a operação para clonar o projeto para a sua máquina, através do Sistema Operacional Windows:

- Acesse o terminal do windows ( prompt de comando)

- Altere o diretório corrente para o local que deseja clonar o repositório em sua máquina
    Ex: c:\avaliacaoDev

- Digite "git clone" ( sem as aspas ), e cole a URL abaixo:
``` https://code-commit-public-at-199807956881:9EIl03WdaNtYgqodZOOsGBjY14ZUR8f9okxICwJ6Mxo=@git-codecommit.sa-east-1.amazonaws.com/v1/repos/AvaliacaoDev ```

- Sua linha de comando deve ficar como abaixo:

> $ git clone https://code-commit-public-at-199807956881:9EIl03WdaNtYgqodZOOsGBjY14ZUR8f> 9okxICwJ6Mxo=@git-codecommit.sa-east-1.amazonaws.com/v1/repos/AvaliacaoDev
> Press Enter to create your local clone.

- Após pressionar "Enter", o projeto será baixado e estará disponível na pasta selecionada


##
##
**Preparando o projeto:**

Importe o projeto **avaliacao-dev** para o eclipse como uma aplicação **Maven**.

- Abrir Eclipse
- Clique em Arquivo > Importar
- Digite Maven na caixa de pesquisa em Selecione uma fonte de importação:
- Selecionar projetos Maven existentes
- Clique em Next
- Clique em Procurar e selecione a pasta que é a raiz do projeto Maven
- Clique em Next
- Clique em Concluir

As bibliotecas necessárias para se trabalhar com o projeto podem ser adquiridas através do Maven. A aplicação ja vem configuradas no pom.xml com as bibliotecas recomendadas. Você pode adquirir essas bibliotecas através do plugin do eclipse ou utilizando o maven, caso o tenha instalado em sua máquina:

**Atualização das bibliotecas através do Eclipse**
Após a importação, com a aplicação **avaliacao-dev** selecionada no eclipse, utilize a tecla de atalho **alt+F5** ou abra o menú do eclipse com o botão direito do mouse > Maven > Update project... e clique em **OK**. Seu projeto baixará automaticamente as bibliotecas necessárias para rodar a aplicação.

**Atualização das bibliotecas através do Maven**
No mesmo diretório onde encontrá-se o pom.xml da aplicação, utilize o comando abaixo:
> mvn dependency:copy-dependencies

## Iniciando a aplicação

Após terminar a atualização das bibliotecas, é hora de inicializar a aplicação. Para isso, dentro da IDE do eclipse, clique no projeto **avaliacao-dev** que foi importado previamente, abra o menú do eclipse com o botão direito do mouse > Run As > **Maven Build...**. Na janela de **Run Configurations**, digite em **Goals**:   _jetty:run_ e clique em **Run**. Observe no console o servidor inicializando e disponibilizando a aplicação.

## Visualizando console H2
Com a aplicação iniciada, é possivel acessar o console do H2, que nos permite visualizar tabelas e rodar instruçoes SQL.

Caso venha algo preenchido nos campos **User Name** e **Password** remova.

**Link para acesso**
>http://localhost:8080/avaliacao/h2-console

**JDBC URL** 
>_jdbc:h2:mem:avaliacao_

## Acessando a aplicação

Após o servidor obter o status de "Started", vá até o navegador da sua máquina e insira a url abaixo:

>http://localhost:8080/avaliacao

Será disponibilizado a página de consulta de Exames.

## Acessando o web-service

Para acessar o serviço de WS utilizando o SOAP, obtenha o WSDL através da URL abaixo:

>http://localhost:8080/avaliacao/soap

No endereço acima, você terá acesso as informações de webservice via Soap. E também, será disponibilizado o WSDL abaixo:

>http://localhost:8080/avaliacao/soap?wsdl

Para utilizar o serviço já disponibilizado de exemplo:

- Abra a ferramenta SoapUi instalada em sua máquina

- Para iniciar a utilização do SoapUI, você deverá criar um novo projeto. Para tal tarefa, você deverá clicar no menu "File>New Soap Project". O SoapUI abrirá um diálogo solicitando o nome do novo projeto. Você também precisará informar em qual pasta o projeto será salvo. Cabe lembrar que, durante modificação do seu projeto, o SoapUI se encarregará de salvar as modificações automaticamente. No entanto, se você desejar, você poderá forçar o salvamento das modificações a qualquer momento por meio do menu "File>Save all" ou pelo atalho "Ctrl+S".

- Na caixa "Initial WSDL", copie e cole a URL do WSDL e clique em OK
    >http://localhost:8080/avaliacao/soap?wsdl

- O SoapUI terá gerado a estrutura do projeto. Abrindo a estrutura de árvore do projeto, o último nível apresentado é o Request 1, destro de "buscarExame". Clique duas vezes com o mouse para abrir a janela de Request 1

- No canto esquerdo da caixa de request, deixe selecionado a aba "XML". Dentro do xml, haverá a seguinte estrutura:
```
   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.sistema.soc.com.br/">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:buscarExame>
         <arg0>?</arg0>
      </soap:buscarExame>
   </soapenv:Body>
</soapenv:Envelope>
```
- Substitua a interrogação dentro da tag <arg0> por valores numéricos. Pode-se substituir pelo número 1, por exemplo. Ao clicar no botão de **play**, no canto superior esquerdo na janela do request, a requisição será efetuada. O resultado será apresentando na janela do lado direito, similar ao exemplo abaixo:
```
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:buscarExameResponse xmlns:ns2="http://soap.sistema.soc.com.br/">
         <return>ExameVo [rowid=1, nome=Acuidade Visual]</return>
      </ns2:buscarExameResponse>
   </S:Body>
</S:Envelope>
 ```
- Caso queira mais informações sobre a utilização da ferramenta SoapUI, acesse a URL abaixo:

    >https://www.soapui.org/getting-started/

## Características Importantes

A aplicação utiliza algumas tecnologias importantes de serem mencionadas.

- **Banco de Dados H2**
O banco de dados utilizados é um banco em memória, que funciona apenas em tempo de execução. Ao inicializar a aplicação, os scripts que se encontram no arquivo **CRIA_TABELAS_E_INSERE_REGISTROS_INICIAIS.sql** são executados e os dados iniciais são disponibilizados para consulta JDBC através do Java.

- **ApplicationResources**
As labels disponibilizadas para apresentação do sistema ficam armazenados no arquivo **ApplicationResources.properties** e no arquivo **ExameAction.properties** Toda nova label disponibilizada deverá ser cadastrada no esquema chave-valor. Maiores informações podem ser obtidas no link abaixo:
    >  https://struts.apache.org/getting-started/message-resource-files.html

- **Struts.xml***
O Struts 2.0 pode ser configurado no arquivo **struts.xml**. Conforme o arquivo já existente do projeto inicial cadastrado, é possível notar as configurações que o Struts precisa para filtrar e interceptar requisições. Novas páginas e novos redirecionamentos podem ser configurados e controlados neste arquivo



## Ajuda

Em caso de dúvidas, entre em contato pelo canal abaixo:

americo@soc.com.br

[eclipse]: https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white
[struts]: https://img.shields.io/badge/Struts%202-%23f1413d.svg?style=for-the-badge&logo=svelte&logoColor=white&color=blue
[java8]:  https://img.shields.io/badge/Java%208-ED8B00?style=for-the-badge&logo=java&logoColor=white&color=red
[maven]: https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white
[h2]: https://img.shields.io/badge/H2-%2307405e.svg?style=for-the-badge&logo=sqlite&logoColor=white
[bootstrap5]: https://img.shields.io/badge/Bootstrap%205-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[jetty]: https://img.shields.io/badge/jetty-%23D42029.svg?style=for-the-badge&logo=apache&logoColor=red&color=grey
[soap]: https://img.shields.io/badge/SOAP-%23f1413d.svg?style=for-the-badge&logo=svelte&logoColor=white&color=yellow
[git]: https://img.shields.io/badge/GIT-2C2255?style=for-the-badge&logo=git&logoColor=yellow&color=black

[Download do eclipse aqui]: https://www.eclipse.org/downloads/
[Guia de instalações JDK 8]: https://www.openlogic.com/openjdk-downloads
[Download do SoapUi aqui]: https://www.soapui.org/downloads/soapui/
[Download do GIT Tortoise aqui]: https://tortoisegit.org/
[Download do GIT aqui]: https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-Instalando-o-Git

  
