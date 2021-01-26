-- DROP DATABASE petshop;

CREATE DATABASE petshop
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;


--==========================================================

CREATE TABLE public.responsavel
(
  cpf character varying(80) PRIMARY KEY NOT NULL,
  nome character varying(200) NOT NULL,
  endereco character varying(200) NOT NULL,
  cidade character varying(80) NOT NULL,
  uf character varying(80) NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.responsavel
  OWNER TO postgres;

              
--==========================================================
       
CREATE TABLE public.animal
(
  id SERIAL PRIMARY KEY,
  responsavelCpf character varying(80) NOT NULL,
  nome character varying(200) NOT NULL,
  raca character varying(80) NOT NULL,
  idade integer NOT NULL,
  tipo character varying(80) NOT NULL,
  FOREIGN KEY(responsavelCpf) REFERENCES public.responsavel(cpf)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.animal
  OWNER TO postgres;

--==========================================================

CREATE TABLE public.funcionario
(
  cpf character varying(80) PRIMARY KEY NOT NULL,
  nome character varying(200) NOT NULL,
  area character varying(80) NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.funcionario
  OWNER TO postgres;

  
--==========================================================
  
CREATE TABLE public.servico
(
  id SERIAL PRIMARY KEY,
  responsavelCpf character varying(80) NOT NULL,
  --funcionarioCpf character varying(80) NOT NULL,
  tipo character varying(80) NOT NULL,
  valor decimal NOT NULL,
  dataInicio Date NOT NULL,
  dataFim Date NOT NULL,
  FOREIGN KEY(responsavelCpf) REFERENCES public.responsavel(cpf)
  --FOREIGN KEY(funcionarioCpf) REFERENCES public.funcionario(cpf)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.servico
  OWNER TO postgres;
  