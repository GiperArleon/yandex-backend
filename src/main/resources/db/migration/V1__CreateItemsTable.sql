CREATE TYPE item_type AS ENUM ('OFFER', 'CATEGORY');
CREATE CAST (CHARACTER VARYING AS item_type) WITH INOUT AS IMPLICIT;

CREATE TABLE IF NOT EXISTS items (
    id UUID PRIMARY KEY NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    update_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    parent_id UUID,
    item_type item_type NOT NULL,
    item_price bigint,
    FOREIGN KEY (parent_id) REFERENCES items(id)
);