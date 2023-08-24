create table imoveis(
id_imovel int primary key not null auto_increment,
descricao_imovel varchar(80),
tipo_imovel varchar(20),
valor_aluguel int(5),
cidade_imovel varchar(40),
estado_imovel varchar(2)
);

insert into imoveis(descricao_imovel, tipo_imovel, valor_aluguel, cidade_imovel, estado_imovel)
values
("casa de 200m², 1 banheiro, 3 quartos", "casa", "1250", "São João Batista", "SC");

select * from imoveis order by estado_imovel;

insert into imoveis(descricao_imovel, tipo_imovel, valor_aluguel, cidade_imovel, estado_imovel)
values
("apartamento de 180m², 1 banheiro, 2 quartos", "apartamento", "950", "Tijucas", "SC"),
("casa de 350m², 2 banheiros, 4 quartos", "casa", "1500", "Itapema", "SC"),
("casa de 195m², 1 banheiro, 2 quartos", "casa", "870", "Curitiba", "PR"),
("sala comercia de 300m², 1 banheiro", "sala", "1700", "Novo Hamburgo", "RS"),
("apartamento de 90m², 1 banheiro, 1 quartos", "apartamento", "700", "Contagem", "MG"),
("sitio de 700m², 3 banheiro, 6 quartos", "sitio", "3000", "Major Gercino", "SC"),
("apartamento de 110m², 1 banheiro, 2 quartos", "apartamento", "1290", "Itajai", "SC"),
("casa de 200m², 1 banheiro, 2 quartos", "casa", "830", "Morro Reuter", "RS");

create table aluguel(
id_aluguel int primary key not null auto_increment,
data_pagamento date,
id_imovel int,
descricao_imovel varchar(80),
tipo_imovel varchar(20),
valor_aluguel int(5),
cidade_imovel varchar(40),
estado_imovel varchar(2),
CONSTRAINT fk_imovel FOREIGN KEY (id_imovel) REFERENCES imoveis(id_imovel),
CONSTRAINT fk_descricao FOREIGN KEY (descricao_imovel) REFERENCES imoveis(descricao_imovel),
CONSTRAINT fk_tipo FOREIGN KEY (tipo_imovel) REFERENCES imoveis(tipo_imovel),
CONSTRAINT fk_valor FOREIGN KEY (valor_aluguel) REFERENCES imoveis(valor_aluguel),
CONSTRAINT fk_cidade FOREIGN KEY (cidade_imovel) REFERENCES imoveis(cidade_imovel),
CONSTRAINT fk_estado FOREIGN KEY (estado_imovel) REFERENCES imoveis(estado_imovel)
);


