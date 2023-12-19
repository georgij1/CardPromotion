create table if not exists card
(
    id_card serial primary key,
    free boolean not null,
    card_number text not null,
    id_customer integer
);