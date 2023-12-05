create table card
(
    id_card     bigserial primary key,
    free        boolean not null,
    card_number text    not null,
    id_customer integer
);
