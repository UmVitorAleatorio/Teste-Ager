# SOC - Avalia��o Dev 

## _Projeto de avalia��o para desenvolvedores Java_    

Consiste em um sistema de Cadastro de Exames, no qual o usu�rio dever� cadastrar novos exames, consultar as informa��es e obter acesso a informa��es atrav�s de web services.

## Conte�do do Projeto

- Crud parcial de Exames ( Inser��o e busca ).
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


## Instala��o

**Pr�-Requisito:**

Tenha o Java 8 instalado em sua m�quina. Em caso de d�vidas, entre no link abaixo:

- [Guia de instala��es JDK 8]

Efetue o download da �ltima vers�o do eclipse, no link abaixo:

- [Download do eclipse aqui]

Efetue o download e instala��o do GIT e GIT Bash, no link abaixo. Caso desejar, poder� utilizar uma ferramenta client para gerenciar o GIT, recomendados o uso do GIT Tortoise:

- [Download do GIT aqui]
- (Opcional) [Download do GIT Tortoise aqui]

Recomendamos a ferramenta SoapUI para efetuar os testes de Web Service:

- [Download do SoapUI aqui]


##
##
**Acessando o projeto:**

Os passos abaixo descrevem a opera��o para clonar o projeto para a sua m�quina, atrav�s do Sistema Operacional Windows:

- Acesse o terminal do windows ( prompt de comando)

- Altere o diret�rio corrente para o local que deseja clonar o reposit�rio em sua m�quina
    Ex: c:\avaliacaoDev

- Digite "git clone" ( sem as aspas ), e cole a URL abaixo:
``` https://code-commit-public-at-199807956881:9EIl03WdaNtYgqodZOOsGBjY14ZUR8f9okxICwJ6Mxo=@git-codecommit.sa-east-1.amazonaws.com/v1/repos/AvaliacaoDev ```

- Sua linha de comando deve ficar como abaixo:

> $ git clone https://code-commit-public-at-199807956881:9EIl03WdaNtYgqodZOOsGBjY14ZUR8f> 9okxICwJ6Mxo=@git-codecommit.sa-east-1.amazonaws.com/v1/repos/AvaliacaoDev
> Press Enter to create your local clone.

- Ap�s pressionar "Enter", o projeto ser� baixado e estar� dispon�vel na pasta selecionada


##
##
**Preparando o projeto:**

Importe o projeto **avaliacao-dev** para o eclipse como uma aplica��o **Maven**.

- Abrir Eclipse
- Clique em Arquivo > Importar
- Digite Maven na caixa de pesquisa em Selecione uma fonte de importa��o:
- Selecionar projetos Maven existentes
- Clique em Next
- Clique em Procurar e selecione a pasta que � a raiz do projeto Maven
- Clique em Next
- Clique em Concluir

As bibliotecas necess�rias para se trabalhar com o projeto podem ser adquiridas atrav�s do Maven. A aplica��o ja vem configuradas no pom.xml com as bibliotecas recomendadas. Voc� pode adquirir essas bibliotecas atrav�s do plugin do eclipse ou utilizando o maven, caso o tenha instalado em sua m�quina:

**Atualiza��o das bibliotecas atrav�s do Eclipse**
Ap�s a importa��o, com a aplica��o **avaliacao-dev** selecionada no eclipse, utilize a tecla de atalho **alt+F5** ou abra o men� do eclipse com o bot�o direito do mouse > Maven > Update project... e clique em **OK**. Seu projeto baixar� automaticamente as bibliotecas necess�rias para rodar a aplica��o.

**Atualiza��o das bibliotecas atrav�s do Maven**
No mesmo diret�rio onde encontr�-se o pom.xml da aplica��o, utilize o comando abaixo:
> mvn dependency:copy-dependencies

## Iniciando a aplica��o

Ap�s terminar a atualiza��o das bibliotecas, � hora de inicializar a aplica��o. Para isso, dentro da IDE do eclipse, clique no projeto **avaliacao-dev** que foi importado previamente, abra o men� do eclipse com o bot�o direito do mouse > Run As > **Maven Build...**. Na janela de **Run Configurations**, digite em **Goals**:   _jetty:run_ e clique em **Run**. Observe no console o servidor inicializando e disponibilizando a aplica��o.

## Visualizando console H2
Com a aplica��o iniciada, � possivel acessar o console do H2, que nos permite visualizar tabelas e rodar instru�oes SQL.

Caso venha algo preenchido nos campos **User Name** e **Password** remova.

**Link para acesso**
>http://localhost:8080/avaliacao/h2-console

**JDBC URL** 
>_jdbc:h2:mem:avaliacao_

## Acessando a aplica��o

Ap�s o servidor obter o status de "Started", v� at� o navegador da sua m�quina e insira a url abaixo:

>http://localhost:8080/avaliacao

Ser� disponibilizado a p�gina de consulta de Exames.

## Acessando o web-service

Para acessar o servi�o de WS utilizando o SOAP, obtenha o WSDL atrav�s da URL abaixo:

>http://localhost:8080/avaliacao/soap

No endere�o acima, voc� ter� acesso as informa��es de webservice via Soap. E tamb�m, ser� disponibilizado o WSDL abaixo:

>http://localhost:8080/avaliacao/soap?wsdl

Para utilizar o servi�o j� disponibilizado de exemplo:

- Abra a ferramenta SoapUi instalada em sua m�quina

- Para iniciar a utiliza��o do SoapUI, voc� dever� criar um novo projeto. Para tal tarefa, voc� dever� clicar no menu "File>New Soap Project". O SoapUI abrir� um di�logo solicitando o nome do novo projeto. Voc� tamb�m precisar� informar em qual pasta o projeto ser� salvo. Cabe lembrar que, durante modifica��o do seu projeto, o SoapUI se encarregar� de salvar as modifica��es automaticamente. No entanto, se voc� desejar, voc� poder� for�ar o salvamento das modifica��es a qualquer momento por meio do menu "File>Save all" ou pelo atalho "Ctrl+S".

- Na caixa "Initial WSDL", copie e cole a URL do WSDL e clique em OK
    >http://localhost:8080/avaliacao/soap?wsdl

- O SoapUI ter� gerado a estrutura do projeto. Abrindo a estrutura de �rvore do projeto, o �ltimo n�vel apresentado � o Request 1, destro de "buscarExame". Clique duas vezes com o mouse para abrir a janela de Request 1

- No canto esquerdo da caixa de request, deixe selecionado a aba "XML". Dentro do xml, haver� a seguinte estrutura:
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
- Substitua a interroga��o dentro da tag <arg0> por valores num�ricos. Pode-se substituir pelo n�mero 1, por exemplo. Ao clicar no bot�o de **play**, no canto superior esquerdo na janela do request, a requisi��o ser� efetuada. O resultado ser� apresentando na janela do lado direito, similar ao exemplo abaixo:
```
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:buscarExameResponse xmlns:ns2="http://soap.sistema.soc.com.br/">
         <return>ExameVo [rowid=1, nome=Acuidade Visual]</return>
      </ns2:buscarExameResponse>
   </S:Body>
</S:Envelope>
 ```
- Caso queira mais informa��es sobre a utiliza��o da ferramenta SoapUI, acesse a URL abaixo:

    >https://www.soapui.org/getting-started/

## Caracter�sticas Importantes

A aplica��o utiliza algumas tecnologias importantes de serem mencionadas.

- **Banco de Dados H2**
O banco de dados utilizados � um banco em mem�ria, que funciona apenas em tempo de execu��o. Ao inicializar a aplica��o, os scripts que se encontram no arquivo **CRIA_TABELAS_E_INSERE_REGISTROS_INICIAIS.sql** s�o executados e os dados iniciais s�o disponibilizados para consulta JDBC atrav�s do Java.

- **ApplicationResources**
As labels disponibilizadas para apresenta��o do sistema ficam armazenados no arquivo **ApplicationResources.properties** e no arquivo **ExameAction.properties** Toda nova label disponibilizada dever� ser cadastrada no esquema chave-valor. Maiores informa��es podem ser obtidas no link abaixo:
    >  https://struts.apache.org/getting-started/message-resource-files.html

- **Struts.xml***
O Struts 2.0 pode ser configurado no arquivo **struts.xml**. Conforme o arquivo j� existente do projeto inicial cadastrado, � poss�vel notar as configura��es que o Struts precisa para filtrar e interceptar requisi��es. Novas p�ginas e novos redirecionamentos podem ser configurados e controlados neste arquivo



## Ajuda

Em caso de d�vidas, entre em contato pelo canal abaixo:

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
[Guia de instala��es JDK 8]: https://www.openlogic.com/openjdk-downloads
[Download do SoapUi aqui]: https://www.soapui.org/downloads/soapui/
[Download do GIT Tortoise aqui]: https://tortoisegit.org/
[Download do GIT aqui]: https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-Instalando-o-Git

  
