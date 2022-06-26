CREATE TABLE IF NOT EXISTS history (
    id UUID NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    update_time TIMESTAMP WITH TIME ZONE NOT NULL,
    parent_id UUID,
    item_type item_type NOT NULL,
    item_price bigint,
    PRIMARY KEY (update_time,id),
    FOREIGN KEY (id) REFERENCES items(id) ON DELETE CASCADE
);
