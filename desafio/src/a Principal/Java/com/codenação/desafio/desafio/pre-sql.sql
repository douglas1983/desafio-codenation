excluir
de event_logs;
excluir
dos usuários;

inserir nos usuários
  (id, nome completo, email, senha, data criada)
valores
  ( 6001 , ' Bruno ' , ' bruno@gmail.com ' , ' 123456 ' , agora ());

inserir nos usuários
  (id, nome completo, email, senha, data criada)
valores
  ( 6002 , ' Fernando ' , ' fernando@email.com ' , ' 123456 ' , now ());

inserir nos usuários
  (id, nome completo, email, senha, data criada)
valores
  ( 6003 , ' Marcela ' , ' marcela@email.com ' , ' 123456 ' , now ());

inserir nos usuários
  (id, nome completo, email, senha, data criada)
valores
  ( 6004 , ' Geovanna ' , ' geovanna@email.com ' , ' 123456 ' , agora ());

inserir nos usuários
  (id, nome completo, email, senha, data criada)
valores
  ( 6005 , ' Alisson ' , ' alisson@email.com ' , ' 123456 ' , agora ());

inserir em event_logs
  (ID, nível, event_log, descrição, origem, event_date, quantidade)
valores
  ( 6001 , ' erro ' , ' teste de log de eventos 1 ' , ' descrição do log de eventos 1 ' , ' origem 1 ' , ' 2020-06-11 ' , 1 );

inserir em event_logs
  (ID, nível, event_log, descrição, origem, event_date, quantidade)
valores
  ( 6002 , ' aviso ' , ' teste do log de eventos 2 ' , ' descrição do log de eventos 2 ' , ' origem 2 ' , ' 2020-06-11 ' , 2 );

inserir em event_logs
  (ID, nível, event_log, descrição, origem, event_date, quantidade)
valores
  ( 6003 , ' info ' , ' teste do log de eventos 3 ' , ' descrição do log de eventos 3 ' , ' origem 3 ' , ' 2020-06-11 ' , 1 );

inserir em event_logs
  (ID, nível, event_log, descrição, origem, event_date, quantidade)
valores
  ( 6004 , ' erro ' , ' teste do log de eventos 4 ' , ' descrição do log de eventos 4 ' , ' origem 4 ' , ' 2020-06-11 ' , 1 );
