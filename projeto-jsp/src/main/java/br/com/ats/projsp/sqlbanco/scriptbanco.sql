CREATE DATABASE banco_projsp
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;


CREATE TABLE public.model_login
(
  login character varying(50) NOT NULL,
  senha character varying(10) NOT NULL,
  CONSTRAINT model_login_login_key UNIQUE (login)
)

INSERT INTO public.model_login(
            login, senha)
    VALUES ('admin', '123');

