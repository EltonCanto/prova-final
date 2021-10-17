# prova-final
Prova final de backend

Acredito que usei todo o conteudo que foi ensinado nesse modulo

Criei um sistema generico de venda para utilizar os conceitos de backend

Micro serviços criado
    *Config server (Para ser a central de configurações dos micros serviços)
    *Erureka server (Para descobrir os serviços ativos)
    *Zuul server (Para fazer a ponte entre os serviços e as demandas)
    *Produtos-ms(Para podermos cadastrar os produtos e atualizarmos e consumi-los no serviço de venda)
    *Vendas-ms (Com ele podemos fazer uma venda usando dois parametros(id do produto e quantiadade do pedidodo) com base nesses dois parametros o ms de venda consulta as informações do produto por meio do FeignClients consumindo o ms produto e monta de forma automatica todos os dados do pedido)
    *Obs: Caso a quantidade de venda seja maior que o estoque o sistema não permite que a venda seja concluida

Usei nesse trabalho:
    *Todas as camadas insinada no curso(model, repository, service, sharad, etc)
    *Todos os recursos de proteção insinados(handler, optional, FallBack, etc)
    *Testei todos os recursos tanto do ms de produtos quanto de venda no Postman, todos os recursos dos micro serviços estão funcional
