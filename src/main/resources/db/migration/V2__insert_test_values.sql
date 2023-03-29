SET
search_path TO panda;

INSERT INTO mails
VALUES (1, 'Mail-1'),
       (2, 'Mail-2');

INSERT INTO owners
VALUES (1, 'Owner-1'),
       (2, 'Owner-2');

INSERT INTO accounts
VALUES (1, 'name-1', 'account-1', 'password-1', 'link-1', 'description-1', 1, 1, 'TEMP', current_timestamp),
       (2, 'name-2', 'account-2', 'password-2', 'link-2', 'description-2', 2, 2, 'GAMES', current_timestamp);
