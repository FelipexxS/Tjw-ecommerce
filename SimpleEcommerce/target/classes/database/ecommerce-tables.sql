CREATE TABLE produto (
	idproduto INT NOT NULL AUTO_INCREMENT,
    nome_produto VARCHAR(45) NOT NULL,
    preco_produto DECIMAL(10, 2) NOT NULL,
    departamento VARCHAR(45) NULL,
    produto_indicado INT NULL,

    CONSTRAINT PKPRODUTO PRIMARY KEY (idproduto)
);

CREATE TABLE cliente (
	idcliente INT NOT NULL AUTO_INCREMENT,
    nome_cliente VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE,
    pwd VARCHAR(100) NOT NULL UNIQUE,
    CPF VARCHAR(45) NULL,
    endereco VARCHAR(45) NOT NULL,
    telefone VARCHAR(45) NULL,

    CONSTRAINT PKCLIENTE PRIMARY KEY (idcliente)
);

CREATE TABLE carrinho (
	idcarrinho INT NOT NULL AUTO_INCREMENT,
    cliente_idcliente INT NOT NULL,
    CONSTRAINT PKCARRINHO PRIMARY KEY (idcarrinho)
);

CREATE TABLE carrinho_produto (
	carrinho_idcarrinho INT NOT NULL,
    produto_idproduto INT NOT NULL,
    quantidade INT NOT NULL,

    CONSTRAINT PKCAPRO PRIMARY KEY (carrinho_idcarrinho, produto_idproduto)
);

ALTER TABLE produto ADD CONSTRAINT PRODUTO_INDICADO FOREIGN KEY (produto_indicado) REFERENCES produto(idproduto);
ALTER TABLE carrinho ADD CONSTRAINT CARRINHO_CLIENTE FOREIGN KEY (cliente_idcliente) REFERENCES cliente(idcliente);
ALTER TABLE carrinho_produto ADD CONSTRAINT CARRINHOID FOREIGN KEY (carrinho_idcarrinho) REFERENCES carrinho(idcarrinho);
ALTER TABLE carrinho_produto ADD CONSTRAINT CARRINHO_PRODUTO FOREIGN KEY (produto_idproduto) REFERENCES produto(idproduto);
