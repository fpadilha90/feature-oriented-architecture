Sei la!

2	Multi-Module Architecture
O modelo desta estrutura foi baseada no conceito de arquitetura multi-modular, onde se faz claro a divisão de responsabilidades por módulos e camadas. 
 
Este tipo de organização tem que ser mantida para tornar visual as funcionalidades do sistema e não enfatizar os frameworks e ferramentas utilizadas em primeiro momento. Funcionalidades dévem conter detalhes e ferramentas, não o contrário.
A estruturação de funcionalides déve ser análisada a cada alteração do projeto para manter a qualidade de interpretação e organização modular.
2.1	App
O modulo “app” é, propriamente dito, o aplicativo. Ele é o responsável por gerar os artefatos de instalação e inicialização do aplicativo. 
 
Alêm disto, também lida com a maior parte das navegações entre módulos e navegação geral do aplicativo. 
Nele ficam o versionamento do app, inicialização da injeção de dependência (2.6 Dependency Injection) e responsabilidades gerais do framework.

2.2	Features
As “Features”, ou funcionalidades, são módulos especializados, tratâm apenas das responsabilidades de uma funcionalidade.
 
Estes módulos são containers de fluxos e componentes. Todas as telas, responsabilidades e regras da competência desta funcionalidades dévem estar neste módulo.
Este módulo é responsavel também por criar a assinatura de serviços que o ele necessita. Por meio de interfaces, “Boundaries”, o módulo indica quais tipos de ações e fluxos ele precisa de complemento, como uma chamada ao serviço ou busca em banco de dados.
Mais tarde estes contratos vão ser implementados pelo módulo “Data” e inseridos por injeção de dependência.
2.3	Data
O modulo Data é a interpretação dos serviço e databases dentro do app. Toda a responsabilidade de fazer chamadas ou buscas é dela, de forma a retornar para as funcionalidades os objetos ideais para o app. 

 
Transformações, filtros e cache são as principais responsabilidades desta camada, que é a mais externa da aplicação.
Caso haja alteração em parametrização em micro-serviços, urls ou formato dos requests/responses, é aqui que as maiores alterações serão concentradas. 
Esta camada também é responsavel por implementar os mocks dos serviços utilizados nas funcionalidades. O aplicativo automaticamente utiliza estas implementações caso o build seja feito no flavour “Mock”. Erros irão ser exibidos em ambos casos, mock e integração, em caso de existir algum boundry sem implementação.
2.4	Common
Todo tipo de componente, regra específica de negócio e classes “core” da aplicação, que são comuns a todos módulos e são de reutilização recorrente, dévem estar dentro deste módulo, que é conhecido por todas funcionalidades.
 
Este modulo, utilizado em composição com guidelines visuais e de comportamento, remove grande parte da duplicação de código, e adiciona integridade ao desenvolvimento e reprodução dos efeitos e telas.
2.5	Dependencies Flow
O fluxo das dependencias dentro da estrutura, acompanha usabilidade e responsabilidade. Este fluxo déve ser configurado e seguido para melhor manutenabilidade do projeto.
 
O “App” tem conhecimento de todos módulos da aplicação, funcionalidades, classes comuns e interpretações de serviços. Ele tanto monta os fluxos do usuário como é responsavel pela injeção de dependencia (2.6 Dependencies Injection), por isto a necessidade de conhecer todas partes do software.
Já o “Common” tem comportamento contrário, não conhece nenhum módulo, mas é conhecido por todos, exatamente para criar este vinculo comum entre todas as partes da aplicação.
As “Features” dependem apenas do módulo “Common”, pelo mesmo propósito acima. Funcionalidades pôdem implementar outras funcionalidades, para utilizar código e componentes especificos. Isto déve ser bem analisado e decidido entre utilização comum (“Common”) ou implementação (“Home” conhece “Balance”). 
Já o “Data” deve conhecer todo módulo que necessita de um contrato para serviço, uma interface Repository/Boundry(5.3 Repository), incluindo “Common” se conter um contrato para serviço. 
2.6	Dependencies Injection
A Injeção de Dependencia do projeto é iniciada no módulo “app”, mas é configurada por cada módulo seguindo suas necessidades. 
Os módulos cliente precisam implementar as configurações de injeção de seus View Models e Use Cases.
O módulo “data” injeta as implementações de repositórios enquanto o módulo “app” garante o start up destas classes. 






















3	Navigation
A estrutura utiliza como navegação conta com a lib “Navigation” da Google. É uma nova forma de criar fluxos, utilizando grafos visuais para melhor interpretação.
 
Torna visual os fluxos da aplicação, muito similar aos Storyboards do iOS. 
Remove a responsabilidade de tratar fluxos programáticamente e stacks de telas, torna nativo o tratamento de deeplinks adicionando a capacidade de abrir qualquer fluxo da aplicação a qualquer momento, por push, link ou intent.
Fluxos que contem telas de diversas funcionalidades, e o fluxo principal (“Home”) estarão no módulo “app”, já fluxos especificos da funcionalidades serão criados dentro da própria funcionalidade. 

4	MVVM
Com a criação do componente ViewModel pelo Google e sua disponibilização no pacote JetPack (inciativa do Google para promover componentes de software visando melhorar o desenvolvimento de aplicativos Android) foi resolvido o problema de acoplamento 1:1 entre view e presenter. 
Os ViewModels são classes simples que interagem com a camada lógica / model e apenas expõem estados / dados e, na verdade, não têm ideia de por que ou como esses dados serão consumidos. Somente a view (activity) mantém a referência da ViewModel e não vice-versa, isso resolve nosso problema de acoplamento rígido. Uma única view pode conter referência a vários ViewModels.
 

Outro ponto que favorece a utilização do MVVM é que a classe ViewModel foi projetada para armazenar e gerenciar dados relacionados à interface do usuário de uma maneira consciente do ciclo de vida, permitindo que os dados sobrevivam a alterações de configuração, como rotações de tela.














5	Data Flow
O Data Flow padrão que deve ser seguido torna as responsabilidades de cada classe únicas. Isto facilitando muito a manutenabilidade e entendimento dos fluxos, cada tipo de ação sabemos exatamente em qual camada seria colocada.
  A interação do usuário na View inicia o flow, esta ação pode ser um click de botão ou até mesmo entrar na tela.
A View chama ações dentro da ViewModel pela sua referência e a partir dai o ViewModel faz o necessário para retornar o que a View necessita, normalmente chamando um UseCase.















5.1	VVM (Feature)
Uma View pode ter vários ViewModels, assim como ViewModels podem ser utilizados em várias Views. O reaproveitamento de código que podemos alcançar com esta estrutura é escalavel com a qualidade da análise dos fluxos.
 

5.2	Interactors (Feature)
O UseCase é um tipo de interactor, ele abstrai um fluxo de negócio programáticamente, isto da um interpretatividade do projeto inclusive para analistas. Nesta camada regras de negócio especficas da aplicação chamam Repositories para executar ações nos micro-serviços ou banco de dados.
UseCases pôdem também chamar outros interactors, sendo eles de qualquer tipo, inclusive outros UseCases.
Os Boundries são interfaces dentro dos módulos de funcionalidade e “Common” que definem os tipos de serviços que aquele fluxo necessita que sejam implementados no “Data”.
 
5.3	Repositories
Já dentro do “Data” a implementação destas interfaces faz o trabalho de chamar diferentes serviços, enviar informações, fazer caches de dados. 
O Repository também é responsavel pela “transformação” dos responses, ele transforma dados que o serviço retornou em objetos “úteis” para a plicação. Isto é, a aplicação, pelos contratos do Boundry, informa o objeto ou resposta ideal que a View ou o UseCase precisa, cabe ao Repostiory fazer as chamadas necessárias para retornar exatamente aquele objeto, transformando um “response” em um “model”.
 
Diferentes Features e fluxos pôdem chamar um mesmo Repository, este tipo de estrutura torna os fluxos maleaveis e com grande reutilização de código entre todas as camadas.
 
