CREATE INDEX IF NOT EXISTS bar_idx_1 ON bar.entity USING GIN (to_tsvector('russian', name));
CREATE INDEX IF NOT EXISTS bar_idx_2 ON bar.entity USING GIN (to_tsvector('russian', address));
CREATE INDEX IF NOT EXISTS bar_idx_3 ON bar.entity USING GIN (to_tsvector('russian', district));