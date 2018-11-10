CREATE SCHEMA IF NOT EXISTS bar;

CREATE INDEX IF NOT EXISTS bar_idx_1 ON bar.bar USING GIN (to_tsvector('russian', name));
CREATE INDEX IF NOT EXISTS bar_idx_2 ON bar.bar USING GIN (to_tsvector('russian', address));
CREATE INDEX IF NOT EXISTS bar_idx_3 ON bar.bar USING GIN (to_tsvector('russian', district));