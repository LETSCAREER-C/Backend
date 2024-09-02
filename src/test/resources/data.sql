-- Insert Liveclass records
INSERT INTO program (
    program_id,
    program_title,
    program_intro,
    program_thumbnail,
    career_tag,
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
    (1, 'Liveclass 1', 'Intro to Liveclass 1', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 100, true, 'https://chat_url_1', 'password1', 50000, 1, 10000),
    (2, 'Liveclass 2', 'Intro to Liveclass 2', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 100, false, 'https://chat_url_2', 'password2', 60000, 1, 5000),
    (3, 'Liveclass 3', 'Intro to Liveclass 3', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 150, true, 'https://chat_url_3', 'password3', 70000, 2, 7000),
    (8, 'Liveclass 4', 'Intro to Liveclass 4', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - 12, CURRENT_TIMESTAMP + 8, CURRENT_TIMESTAMP + 2, CURRENT_TIMESTAMP + 28, 'LIVECLASS', 120, true, 'https://chat_url_8', 'password8', 55000, 1, 12000),
    (9, 'Liveclass 5', 'Intro to Liveclass 5', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 12, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 32, 'LIVECLASS', 130, false, 'https://chat_url_9', 'password9', 65000, 2, 8000),
    (10, 'Liveclass 6', 'Intro to Liveclass 6', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 8, CURRENT_TIMESTAMP + 15, CURRENT_TIMESTAMP + 3, CURRENT_TIMESTAMP + 25, 'LIVECLASS', 140, true, 'https://chat_url_10', 'password10', 75000, 1, 9000);

-- Insert Challenge records
INSERT INTO program (
    program_id,
    program_title,
    program_intro,
    program_thumbnail,
    career_tag,
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
    (4, 'Challenge 1', 'Intro to Challenge 1', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 200, true, 'https://chat_url_4', 'password4', 80000, 1, 15000, CURRENT_TIMESTAMP + 23),
    (5, 'Challenge 2', 'Intro to Challenge 2', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 250, false, 'https://chat_url_5', 'password5', 90000, 1, 20000, CURRENT_TIMESTAMP + 23),
    (6, 'Challenge 3', 'Intro to Challenge 3', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 300, true, 'https://chat_url_6', 'password6', 100000, 2, 25000, CURRENT_TIMESTAMP + 23),
    (7, 'Challenge 4', 'Intro to Challenge 4', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 350, false, 'https://chat_url_7', 'password7', 110000, 2, 30000, CURRENT_TIMESTAMP + 23),
    (11, 'Challenge 5', 'Intro to Challenge 5', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - 18, CURRENT_TIMESTAMP + 3, CURRENT_TIMESTAMP + 6, CURRENT_TIMESTAMP + 22, 'CHALLENGE', 220, true, 'https://chat_url_11', 'password11', 85000, 2, 17000, CURRENT_TIMESTAMP + 24),
    (12, 'Challenge 6', 'Intro to Challenge 6', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 20, CURRENT_TIMESTAMP + 2, CURRENT_TIMESTAMP + 7, CURRENT_TIMESTAMP + 21, 'CHALLENGE', 270, false, 'https://chat_url_12', 'password12', 95000, 1, 22000, CURRENT_TIMESTAMP + 24),
    (13, 'Challenge 7', 'Intro to Challenge 7', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 19, CURRENT_TIMESTAMP + 4, CURRENT_TIMESTAMP + 8, CURRENT_TIMESTAMP + 24, 'CHALLENGE', 320, true, 'https://chat_url_13', 'password13', 105000, 2, 27000, CURRENT_TIMESTAMP + 24),
    (14, 'Challenge 8', 'Intro to Challenge 8', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 16, CURRENT_TIMESTAMP + 6, CURRENT_TIMESTAMP + 9, CURRENT_TIMESTAMP + 23, 'CHALLENGE', 370, false, 'https://chat_url_14', 'password14', 115000, 1, 32000, CURRENT_TIMESTAMP + 24);