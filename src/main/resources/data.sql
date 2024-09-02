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
    (1, 'Liveclass 1', 'Intro to Liveclass 1', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 10 DAY, CURRENT_TIMESTAMP + INTERVAL 10 DAY, CURRENT_TIMESTAMP + INTERVAL 1 DAY, CURRENT_TIMESTAMP + INTERVAL 30 DAY, 'LIVECLASS', 100, 1, 'https://chat_url_1', 'password1', 50000, 1, 10000),
    (2, 'Liveclass 2', 'Intro to Liveclass 2', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 10 DAY, CURRENT_TIMESTAMP + INTERVAL 10 DAY, CURRENT_TIMESTAMP + INTERVAL 1 DAY, CURRENT_TIMESTAMP + INTERVAL 30 DAY, 'LIVECLASS', 100, 0, 'https://chat_url_2', 'password2', 60000, 1, 5000),
    (3, 'Liveclass 3', 'Intro to Liveclass 3', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 10 DAY, CURRENT_TIMESTAMP + INTERVAL 10 DAY, CURRENT_TIMESTAMP + INTERVAL 1 DAY, CURRENT_TIMESTAMP + INTERVAL 30 DAY, 'LIVECLASS', 150, 1, 'https://chat_url_3', 'password3', 70000, 2, 7000),
    (8, 'Liveclass 4', 'Intro to Liveclass 4', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 12 DAY, CURRENT_TIMESTAMP + INTERVAL 8 DAY, CURRENT_TIMESTAMP + INTERVAL 2 DAY, CURRENT_TIMESTAMP + INTERVAL 28 DAY, 'LIVECLASS', 120, 1, 'https://chat_url_8', 'password8', 55000, 1, 12000),
    (9, 'Liveclass 5', 'Intro to Liveclass 5', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 10 DAY, CURRENT_TIMESTAMP + INTERVAL 12 DAY, CURRENT_TIMESTAMP + INTERVAL 1 DAY, CURRENT_TIMESTAMP + INTERVAL 32 DAY, 'LIVECLASS', 130, 0, 'https://chat_url_9', 'password9', 65000, 2, 8000),
    (10, 'Liveclass 6', 'Intro to Liveclass 6', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 8 DAY, CURRENT_TIMESTAMP + INTERVAL 15 DAY, CURRENT_TIMESTAMP + INTERVAL 3 DAY, CURRENT_TIMESTAMP + INTERVAL 25 DAY, 'LIVECLASS', 140, 1, 'https://chat_url_10', 'password10', 75000, 1, 9000);

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
    (4, 'Challenge 1', 'Intro to Challenge 1', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 15 DAY, CURRENT_TIMESTAMP + INTERVAL 5 DAY, CURRENT_TIMESTAMP + INTERVAL 5 DAY, CURRENT_TIMESTAMP + INTERVAL 20 DAY, 'CHALLENGE', 200, 1, 'https://chat_url_4', 'password4', 80000, 1, 15000, CURRENT_TIMESTAMP + INTERVAL 23 DAY),
    (5, 'Challenge 2', 'Intro to Challenge 2', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 15 DAY, CURRENT_TIMESTAMP + INTERVAL 5 DAY, CURRENT_TIMESTAMP + INTERVAL 5 DAY, CURRENT_TIMESTAMP + INTERVAL 20 DAY, 'CHALLENGE', 250, 0, 'https://chat_url_5', 'password5', 90000, 1, 20000, CURRENT_TIMESTAMP + INTERVAL 23 DAY),
    (6, 'Challenge 3', 'Intro to Challenge 3', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 15 DAY, CURRENT_TIMESTAMP + INTERVAL 5 DAY, CURRENT_TIMESTAMP + INTERVAL 5 DAY, CURRENT_TIMESTAMP + INTERVAL 20 DAY, 'CHALLENGE', 300, 1, 'https://chat_url_6', 'password6', 100000, 2, 25000, CURRENT_TIMESTAMP + INTERVAL 23 DAY),
    (7, 'Challenge 4', 'Intro to Challenge 4', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 15 DAY, CURRENT_TIMESTAMP + INTERVAL 5 DAY, CURRENT_TIMESTAMP + INTERVAL 5 DAY, CURRENT_TIMESTAMP + INTERVAL 20 DAY, 'CHALLENGE', 350, 0, 'https://chat_url_7', 'password7', 110000, 2, 30000, CURRENT_TIMESTAMP + INTERVAL 23 DAY),
    (11, 'Challenge 5', 'Intro to Challenge 5', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 18 DAY, CURRENT_TIMESTAMP + INTERVAL 3 DAY, CURRENT_TIMESTAMP + INTERVAL 6 DAY, CURRENT_TIMESTAMP + INTERVAL 22 DAY, 'CHALLENGE', 220, 1, 'https://chat_url_11', 'password11', 85000, 2, 17000, CURRENT_TIMESTAMP + INTERVAL 24 DAY),
    (12, 'Challenge 6', 'Intro to Challenge 6', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 20 DAY, CURRENT_TIMESTAMP + INTERVAL 2 DAY, CURRENT_TIMESTAMP + INTERVAL 7 DAY, CURRENT_TIMESTAMP + INTERVAL 21 DAY, 'CHALLENGE', 270, 0, 'https://chat_url_12', 'password12', 95000, 1, 22000, CURRENT_TIMESTAMP + INTERVAL 24 DAY),
    (13, 'Challenge 7', 'Intro to Challenge 7', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 19 DAY, CURRENT_TIMESTAMP + INTERVAL 4 DAY, CURRENT_TIMESTAMP + INTERVAL 8 DAY, CURRENT_TIMESTAMP + INTERVAL 24 DAY, 'CHALLENGE', 320, 1, 'https://chat_url_13', 'password13', 105000, 2, 27000, CURRENT_TIMESTAMP + INTERVAL 24 DAY),
    (14, 'Challenge 8', 'Intro to Challenge 8', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - INTERVAL 16 DAY, CURRENT_TIMESTAMP + INTERVAL 6 DAY, CURRENT_TIMESTAMP + INTERVAL 9 DAY, CURRENT_TIMESTAMP + INTERVAL 23 DAY, 'CHALLENGE', 370, 0, 'https://chat_url_14', 'password14', 115000, 1, 32000, CURRENT_TIMESTAMP + INTERVAL 24 DAY);