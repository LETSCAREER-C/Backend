-- Insert Liveclass records
INSERT INTO program (
    program_id,
    program_title,
    program_intro,
    program_thumbnail,
    recruit_status,
    recruit_start_date,
    recruit_end_date,
    program_start_date,
    program_end_date,
    dtype,
    total,
    is_online,
    open_chatting,
    open_chatting_password,
    price,
    price_type,
    discount_amount
)
VALUES
    (1, 'Liveclass 1', 'Intro to Liveclass 1', 'https://image_url', 'RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 100, true, 'https://chat_url_1', 'password1', 50000, 1, 10000),
    (2, 'Liveclass 2', 'Intro to Liveclass 2', 'https://image_url', 'RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 100, false, 'https://chat_url_2', 'password2', 60000, 1, 5000),
    (3, 'Liveclass 3', 'Intro to Liveclass 3', 'https://image_url', 'RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 150, true, 'https://chat_url_3', 'password3', 70000, 2, 7000);

-- Insert Challenge records
INSERT INTO program (
    program_id,
    program_title,
    program_intro,
    program_thumbnail,
    recruit_status,
    recruit_start_date,
    recruit_end_date,
    program_start_date,
    program_end_date,
    dtype,
    total,
    is_online,
    open_chatting,
    open_chatting_password,
    price,
    price_type,
    discount_amount,
    ot_date
)
VALUES
    (4, 'Challenge 1', 'Intro to Challenge 1', 'https://image_url', 'RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 200, true, 'https://chat_url_4', 'password4', 80000, 1, 15000, CURRENT_TIMESTAMP + 23),
    (5, 'Challenge 2', 'Intro to Challenge 2', 'https://image_url', 'RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 250, false, 'https://chat_url_5', 'password5', 90000, 1, 20000, CURRENT_TIMESTAMP + 23),
    (6, 'Challenge 3', 'Intro to Challenge 3', 'https://image_url', 'RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 300, true, 'https://chat_url_6', 'password6', 100000, 2, 25000, CURRENT_TIMESTAMP + 23),
    (7, 'Challenge 4', 'Intro to Challenge 4', 'https://image_url', 'RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 350, false, 'https://chat_url_7', 'password7', 110000, 2, 30000, CURRENT_TIMESTAMP + 23);

-- Insert tags for Liveclass records
INSERT INTO program_career_tag (program_id, career_tag)
VALUES
    (1, 'CAREER_EXPLORE'),
    (1, 'DOCUMENT_PREPARE'),
    (2, 'CAREER_EXPLORE'),
    (2, 'DOCUMENT_PREPARE'),
    (3, 'CAREER_EXPLORE');

-- Insert tags for Challenge records
INSERT INTO program_career_tag (program_id, career_tag)
VALUES
    (4, 'DOCUMENT_PREPARE'),
    (4, 'INTERVIEW_PREPARE'),
    (5, 'DOCUMENT_PREPARE'),
    (6, 'CAREER_EXPLORE'),
    (7, 'DOCUMENT_PREPARE'),
    (7, 'INTERVIEW_PREPARE');