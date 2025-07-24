create table if not exists time_capsule (
    id serial,
    email varchar(255),
    message text,
    ia_question text,
    ia_answer_now text,
    ia_answer_future text,
    date_to_send timestamp,
    sent_date timestamp,
    created_at timestamp default current_timestamp,
    constraint pk_time_capsule primary key (id)
);