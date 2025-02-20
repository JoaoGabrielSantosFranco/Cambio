# 💱 CambioTelegram - Bot de Cotação de Moedas no Telegram  

## 📝 Sobre o Projeto  

CambioTelegram é um bot do Telegram que permite consultar taxas de câmbio em tempo real de forma simples e rápida. Ele utiliza a [AwesomeAPI](https://docs.awesomeapi.com.br/) para obter os valores atualizados das moedas e retorna informações detalhadas sobre a cotação diretamente no chat do Telegram.  

A ideia do projeto surgiu da necessidade de verificar rapidamente o valor de moedas estrangeiras sem precisar acessar sites ou aplicativos bancários. Com apenas um comando, o usuário recebe a cotação desejada, tornando o processo mais eficiente e acessível. Essa necessidade se tornou ainda mais relevante depois que o Google deixou de exibir diretamente a conversão de moedas nos resultados de pesquisa, tornando mais difícil obter essas informações de forma rápida.  

### 🔹 Principais funcionalidades  
✅ Consulta de taxas de câmbio em tempo real  
✅ Suporte a múltiplas moedas  
✅ Integração com o Telegram para uso direto no chat  
✅ Código aberto e de fácil modificação  

# Configuração

## 1. Clonar o Repositório

```bash
git clone https://github.com/JoaoGabrielSantosFranco/CambioTelegram.git
cd CambioTelegram
```

## 2. Configurar as Propriedades da Aplicação

Crie um arquivo `application.properties` dentro de `src/main/resources/` e adicione as seguintes configurações:

```properties
spring.application.name=CambioTelegram
api.url=https://economia.awesomeapi.com.br/json/daily/
telegram.bot.token=SEU_TOKEN_AQUI
telegram.chat.id=SEU_CHAT_ID_AQUI
```

## 3. Construir e Executar o Projeto

### Usando Maven

```bash
mvn clean package
java -jar target/CambioTelegram-0.0.1-SNAPSHOT.jar
```

### Usando Spring Boot

```bash
mvn spring-boot:run
```

# Como Funciona

- O bot recebe comandos no Telegram e busca a cotação da moeda desejada usando a API da AwesomeAPI.
- Retorna informações como código da moeda, nome, taxa de compra.

# Exemplo de Uso

No chat do Telegram, envie uma mensagem como:

```
dolar
```

O bot responderá com a taxa de câmbio atual do dólar.

# Contribuição

1. Fork este repositório.
2. Crie um branch com a nova funcionalidade:

```bash
git checkout -b minha-feature
```

3. Commit suas mudanças:

```bash
git commit -m 'feat: minha nova funcionalidade'
```

4. Push para o branch:

```bash
git push origin minha-feature
```

5. Abra um Pull Request.
