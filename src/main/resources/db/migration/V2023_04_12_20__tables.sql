CREATE TABLE public.client (
     chat_id BIGINT PRIMARY KEY,
     created TIMESTAMP NOT NULL DEFAULT now(),
     updated TIMESTAMP NOT NULL DEFAULT now()
);
