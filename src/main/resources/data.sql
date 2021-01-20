INSERT INTO TB_CAIXA_ELETRONICO(notas_cem, notas_cinq, notas_dez, notas_vinte) VALUES (10, 10, 10, 10);

INSERT INTO TB_CLIENTE(nome) VALUES ('João Silva');
INSERT INTO TB_CLIENTE(nome) VALUES ('Maria Aparecida');

INSERT INTO TB_USUARIO(username, password) VALUES('123456', '$2a$10$3etZA9erxYMBqDhgcAWCn.z2dESIumrSYF0d52gy6a4WkFRmGlI/C');
INSERT INTO TB_USUARIO(username, password) VALUES('654321', '$2a$10$BI5KQaxoT1ZKElYJWoAVm.EI1KN3a8REvZe/PuSgHa9upcDdXFFzW');

INSERT INTO TB_CONTA(agencia, numero_conta, saldo, cliente_id) VALUES ('1111', '123456', 200.0, 1);
INSERT INTO TB_CONTA(agencia, numero_conta, saldo, cliente_id) VALUES ('2222', '654321', 300.0, 2);

INSERT INTO TB_PERFIL(role) VALUES ('ROLE_CLIENTE');
INSERT INTO TB_PERFIL(role) VALUES ('ROLE_ADM');

INSERT INTO TB_USUARIO_PERFIL(usuario_username, perfil_id) VALUES ('123456', 1);
INSERT INTO TB_USUARIO_PERFIL(usuario_username, perfil_id) VALUES ('654321', 2);