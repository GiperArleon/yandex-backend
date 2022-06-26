CREATE TABLE IF NOT EXISTS history (
    id UUID NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    update_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    parent_id UUID,
    item_type item_type NOT NULL,
    item_price bigint,
    FOREIGN KEY (id) REFERENCES items(id) ON DELETE CASCADE
);
ALTER TABLE public.history OWNER TO postgres;
ALTER TABLE ONLY history ADD CONSTRAINT "ID_PKEY" PRIMARY KEY (update_time,id);