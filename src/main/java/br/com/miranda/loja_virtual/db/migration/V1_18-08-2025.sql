---Trazer a constrait específica – guarda no arquivo sql
select CONSTRAINT_name from information_schema.constraint_column_usage
where TABLE_name = 'usuario_acesso' and COLUMN_name = 'acesso_id'
and CONSTRAINT_name <>'usuario_acesso_acesso_id_key';

--Excluir a constraint
alter table usuario_acesso drop CONSTRAINT "usuario_acesso_acesso_id_key";