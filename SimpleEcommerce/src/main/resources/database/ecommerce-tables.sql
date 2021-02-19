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



ALTER TABLE produto ADD CONSTRAINT PRODUTO_INDICADO FOREIGN KEY (produto_indicado) REFERENCES produto(idproduto);
