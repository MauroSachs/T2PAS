-- Insert into usuario_model
INSERT INTO usuario_model (senha, usuario) VALUES ('senha123', 'admin');

-- Insert into cliente_model
INSERT INTO cliente_model (email, nome) VALUES ('joao@email.com', 'João Silva');
INSERT INTO cliente_model (email, nome) VALUES ('maria.souza@example.com', 'Maria Souza');
INSERT INTO cliente_model (email, nome) VALUES ('ana.costa@example.com', 'Ana Costa');
INSERT INTO cliente_model (email, nome) VALUES ('carlos.oliveira@example.com', 'Carlos Oliveira');
INSERT INTO cliente_model (email, nome) VALUES ('lucas.pereira@example.com', 'Lucas Pereira');
INSERT INTO cliente_model (email, nome) VALUES ('fernanda.lima@example.com', 'Fernanda Lima');
INSERT INTO cliente_model (email, nome) VALUES ('bruno.alves@example.com', 'Bruno Alves');
INSERT INTO cliente_model (email, nome) VALUES ('juliana.rodrigues@example.com', 'Juliana Rodrigues');
INSERT INTO cliente_model (email, nome) VALUES ('roberto.martins@example.com', 'Roberto Martins');
INSERT INTO cliente_model (email, nome) VALUES ('patricia.fernandes@example.com', 'Patrícia Fernandes');

-- Insert into aplicativo_model
INSERT INTO aplicativo_model (custo_mensal, nome) VALUES (19.99, 'Spotify');
INSERT INTO aplicativo_model (custo_mensal, nome) VALUES (29.99, 'Netflix');
INSERT INTO aplicativo_model (custo_mensal, nome) VALUES (9.99, 'Amazon Prime Video');
INSERT INTO aplicativo_model (custo_mensal, nome) VALUES (14.99, 'Disney+');
INSERT INTO aplicativo_model (custo_mensal, nome) VALUES (39.99, 'HBO Max');

-- Insert into assinatura_model
INSERT INTO assinatura_model (fim_vigencia, inicio_vigencia, aplicativo_id, cliente_id)
VALUES ('2024-08-01', '2024-06-01', 1, 1);

INSERT INTO assinatura_model (fim_vigencia, inicio_vigencia, aplicativo_id, cliente_id)
VALUES ('2024-08-01', '2024-06-01', 2, 2);

INSERT INTO assinatura_model (fim_vigencia, inicio_vigencia, aplicativo_id, cliente_id)
VALUES ('2024-07-01', '2024-06-01', 3, 3);

INSERT INTO assinatura_model (fim_vigencia, inicio_vigencia, aplicativo_id, cliente_id)
VALUES ('2024-05-01', '2024-04-01', 4, 4);

INSERT INTO assinatura_model (fim_vigencia, inicio_vigencia, aplicativo_id, cliente_id)
VALUES ('2024-02-01', '2024-01-01', 5, 5);

-- Insert into pagamento_model
INSERT INTO pagamento_model (data_pagamento, promocao, valor_pago, assinatura_id)
VALUES ('2024-01-01', 'Cupom15', 29.99, 1);

INSERT INTO pagamento_model (data_pagamento, promocao, valor_pago, assinatura_id)
VALUES ('2024-01-01', 'Cupom50', 19.99, 2);

INSERT INTO pagamento_model (data_pagamento, promocao, valor_pago, assinatura_id)
VALUES ('2024-01-01', 'none', 9.99, 3);

INSERT INTO pagamento_model (data_pagamento, promocao, valor_pago, assinatura_id)
VALUES ('2024-01-01', 'none', 14.99, 4);

INSERT INTO pagamento_model (data_pagamento, promocao, valor_pago, assinatura_id)
VALUES ('2024-01-01', 'none', 39.99, 5);

-- Insert into assinatura_model_pagamentos
INSERT INTO assinatura_model_pagamentos (assinatura_model_id, pagamentos_id) VALUES (1, 1);
INSERT INTO assinatura_model_pagamentos (assinatura_model_id, pagamentos_id) VALUES (2, 2);
INSERT INTO assinatura_model_pagamentos (assinatura_model_id, pagamentos_id) VALUES (3, 3);
INSERT INTO assinatura_model_pagamentos (assinatura_model_id, pagamentos_id) VALUES (4, 4);
INSERT INTO assinatura_model_pagamentos (assinatura_model_id, pagamentos_id) VALUES (5, 5);
