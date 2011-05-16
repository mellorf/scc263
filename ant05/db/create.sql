--
-- PostgreSQL database dump
--

SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: _news; Type: TABLE; Schema: public; Owner: usernews; Tablespace: 
--

CREATE TABLE _news (
    datetime timestamp without time zone NOT NULL,
    code integer NOT NULL,
    title character varying(255) NOT NULL,
    body text NOT NULL
);


ALTER TABLE public._news OWNER TO usernews;

--
-- Name: _rss; Type: TABLE; Schema: public; Owner: usernews; Tablespace: 
--

CREATE TABLE _rss (
    datetime timestamp without time zone,
    link character varying(255) NOT NULL,
    title text,
    description text
);


ALTER TABLE public._rss OWNER TO usernews;

--
-- Name: _user; Type: TABLE; Schema: public; Owner: usernews; Tablespace: 
--

CREATE TABLE _user (
    name character varying(50) NOT NULL,
    login character varying(10) NOT NULL,
    passwd character varying(10) NOT NULL
);


ALTER TABLE public._user OWNER TO usernews;

--
-- Name: _news_seq; Type: SEQUENCE; Schema: public; Owner: usernews
--

CREATE SEQUENCE _news_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public._news_seq OWNER TO usernews;

--
-- Name: _news_seq; Type: SEQUENCE SET; Schema: public; Owner: usernews
--

SELECT pg_catalog.setval('_news_seq', 1, false);


--
-- Data for Name: _news; Type: TABLE DATA; Schema: public; Owner: usernews
--

COPY _news (datetime, code, title, body) FROM stdin;
\.


--
-- Data for Name: _rss; Type: TABLE DATA; Schema: public; Owner: usernews
--

COPY _rss (datetime, link, title, description) FROM stdin;
\.


--
-- Data for Name: _user; Type: TABLE DATA; Schema: public; Owner: usernews
--

COPY _user (name, login, passwd) FROM stdin;
\.


--
-- Name: _news_pkey; Type: CONSTRAINT; Schema: public; Owner: usernews; Tablespace: 
--

ALTER TABLE ONLY _news
    ADD CONSTRAINT _news_pkey PRIMARY KEY (code);


--
-- Name: _rss_pkey; Type: CONSTRAINT; Schema: public; Owner: usernews; Tablespace: 
--

ALTER TABLE ONLY _rss
    ADD CONSTRAINT _rss_pkey PRIMARY KEY (link);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

