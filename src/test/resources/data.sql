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
    passed_num,
    failed_num,
    is_online,
    open_chatting,
    open_chatting_password,
    price,
    price_type,
    discount_amount,
    pc_main_image_url,
    mobile_main_image_url
)
VALUES
    (1, 'Liveclass 1', 'Intro to Liveclass 1', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 100, 30, 10, true, 'https://chat_url_1', 'password1', 50000, 1, 10000, 'https://pc_main_image_url', 'https://mobile_main_image_url'),
    (2, 'Liveclass 2', 'Intro to Liveclass 2', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 100, 20, 10, false, 'https://chat_url_2', 'password2', 60000, 1, 5000, 'https://pc_main_image_url', 'https://mobile_main_image_url'),
    (3, 'Liveclass 3', 'Intro to Liveclass 3', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 10, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 30, 'LIVECLASS', 150, 5, 1, true, 'https://chat_url_3', 'password3', 70000, 2, 7000, 'https://pc_main_image_url', 'https://mobile_main_image_url'),
    (8, 'Liveclass 4', 'Intro to Liveclass 4', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - 12, CURRENT_TIMESTAMP + 8, CURRENT_TIMESTAMP + 2, CURRENT_TIMESTAMP + 28, 'LIVECLASS', 120, 12, 2, true, 'https://chat_url_8', 'password8', 55000, 1, 12000, 'https://pc_main_image_url', 'https://mobile_main_image_url'),
    (9, 'Liveclass 5', 'Intro to Liveclass 5', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 10, CURRENT_TIMESTAMP + 12, CURRENT_TIMESTAMP + 1, CURRENT_TIMESTAMP + 32, 'LIVECLASS', 130, 13, 5, false, 'https://chat_url_9', 'password9', 65000, 2, 8000, 'https://pc_main_image_url', 'https://mobile_main_image_url'),
    (10, 'Liveclass 6', 'Intro to Liveclass 6', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 8, CURRENT_TIMESTAMP + 15, CURRENT_TIMESTAMP + 3, CURRENT_TIMESTAMP + 25, 'LIVECLASS', 140, 14, 9, true, 'https://chat_url_10', 'password10', 75000, 1, 9000, 'https://pc_main_image_url', 'https://mobile_main_image_url');

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
    ot_date,
    pc_main_image_url,
    mobile_main_image_url,
    passed_num,
    failed_num
)
VALUES
    (4, 'Challenge 1', 'Intro to Challenge 1', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 200, true, 'https://chat_url_4', 'password4', 80000, 1, 15000, CURRENT_TIMESTAMP + 23, 'https://pc_main_image_url', 'https://mobile_main_image_url', 30, 10),
    (5, 'Challenge 2', 'Intro to Challenge 2', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 250, false, 'https://chat_url_5', 'password5', 90000, 1, 20000, CURRENT_TIMESTAMP + 23, 'https://pc_main_image_url', 'https://mobile_main_image_url', 30, 10),
    (6, 'Challenge 3', 'Intro to Challenge 3', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 300, true, 'https://chat_url_6', 'password6', 100000, 2, 25000, CURRENT_TIMESTAMP + 23, 'https://pc_main_image_url', 'https://mobile_main_image_url', 30, 10),
    (7, 'Challenge 4', 'Intro to Challenge 4', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 15, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 5, CURRENT_TIMESTAMP + 20, 'CHALLENGE', 350, false, 'https://chat_url_7', 'password7', 110000, 2, 30000, CURRENT_TIMESTAMP + 23, 'https://pc_main_image_url', 'https://mobile_main_image_url', 30, 10),
    (11, 'Challenge 5', 'Intro to Challenge 5', 'https://image_url', 'CAREER_EXPLORE','RECRUITING', CURRENT_TIMESTAMP - 18, CURRENT_TIMESTAMP + 3, CURRENT_TIMESTAMP + 6, CURRENT_TIMESTAMP + 22, 'CHALLENGE', 220, true, 'https://chat_url_11', 'password11', 85000, 2, 17000, CURRENT_TIMESTAMP + 24, 'https://pc_main_image_url', 'https://mobile_main_image_url', 30, 10),
    (12, 'Challenge 6', 'Intro to Challenge 6', 'https://image_url', 'DOCUMENT_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 20, CURRENT_TIMESTAMP + 2, CURRENT_TIMESTAMP + 7, CURRENT_TIMESTAMP + 21, 'CHALLENGE', 270, false, 'https://chat_url_12', 'password12', 95000, 1, 22000, CURRENT_TIMESTAMP + 24, 'https://pc_main_image_url', 'https://mobile_main_image_url', 30, 10),
    (13, 'Challenge 7', 'Intro to Challenge 7', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 19, CURRENT_TIMESTAMP + 4, CURRENT_TIMESTAMP + 8, CURRENT_TIMESTAMP + 24, 'CHALLENGE', 320, true, 'https://chat_url_13', 'password13', 105000, 2, 27000, CURRENT_TIMESTAMP + 24, 'https://pc_main_image_url', 'https://mobile_main_image_url', 30, 10),
    (14, 'Challenge 8', 'Intro to Challenge 8', 'https://image_url', 'INTERVIEW_PREPARE','RECRUITING', CURRENT_TIMESTAMP - 16, CURRENT_TIMESTAMP + 6, CURRENT_TIMESTAMP + 9, CURRENT_TIMESTAMP + 23, 'CHALLENGE', 370, false, 'https://chat_url_14', 'password14', 115000, 1, 32000, CURRENT_TIMESTAMP + 24, 'https://pc_main_image_url', 'https://mobile_main_image_url', 30, 10);

-- Insert Member records
INSERT INTO member (id, name, dream_company, dream_work_field, major, academic_year)
VALUES
    (1, 'Member 1', 'Company 1', 'Field 1', 'Major 1', 3),
    (2, 'Member 2', 'Company 2', 'Field 2', 'Major 2', 4),
    (3, 'Member 3', 'Company 3', 'Field 3', 'Major 3', 2),
    (4, 'Member 4', 'Company 4', 'Field 4', 'Major 4', 1),
    (5, 'Member 5', 'Company 5', 'Field 5', 'Major 5', 3),
    (6, 'Member 6', 'Company 6', 'Field 6', 'Major 6', 4),
    (7, 'Member 7', 'Company 7', 'Field 7', 'Major 7', 2),
    (8, 'Member 8', 'Company 8', 'Field 8', 'Major 8', 1),
    (9, 'Member 9', 'Company 9', 'Field 9', 'Major 9', 3),
    (10, 'Member 10', 'Company 10', 'Field 10', 'Major 10', 4);

-- Insert Review records
INSERT INTO review (id, title, content, status,  order_number, grade, created_at, program_id, member_id)
VALUES
    (1, 'Great Liveclass 1', 'Learned a lot from Liveclass 1', 'EMPLOYED', 1, 5, CURRENT_TIMESTAMP - 2, 1, 1),
    (2, 'Good Liveclass 2', 'Liveclass 2 was very informative', 'EMPLOYED',2, 4, CURRENT_TIMESTAMP - 3, 1, 2),
    (3, 'Excellent Liveclass 3', 'Highly recommend Liveclass 3', 'EMPLOYED',3, 5, CURRENT_TIMESTAMP - 4, 1, 3),
    (4, 'Challenging Challenge 1', 'Challenge 1 pushed my limits','EMPLOYED', 1, 5, CURRENT_TIMESTAMP - 1, 1, 4),
    (5, 'Tough Challenge 2', 'Challenge 2 was tough but rewarding','EMPLOYED', 2, 4, CURRENT_TIMESTAMP - 2, 1, 5),
    (6, 'Engaging Challenge 3', 'Challenge 3 kept me engaged', 'EMPLOYED',3, 5, CURRENT_TIMESTAMP - 3, 1, 6),
    (7, 'Rewarding Challenge 4', 'Challenge 4 was very rewarding', 'EMPLOYED',4, 4, CURRENT_TIMESTAMP - 4, 1, 7);

-- Insert Curriculum records
INSERT INTO curriculum (id, title, content, order_number, program_id)
VALUES
    (1, 'Curriculum for Liveclass 1', 'Content for Liveclass 1', '1', 1),
    (2, 'Curriculum for Liveclass 2', 'Content for Liveclass 2', '2', 1),
    (3, 'Curriculum for Liveclass 3', 'Content for Liveclass 3', '3', 1),
    (4, 'Curriculum for Challenge 1', 'Content for Challenge 1', '1', 1),
    (5, 'Curriculum for Challenge 2', 'Content for Challenge 2', '2', 1),
    (6, 'Curriculum for Challenge 3', 'Content for Challenge 3', '3', 1),
    (7, 'Curriculum for Challenge 4', 'Content for Challenge 4', '4', 2);

-- Insert Faq records
INSERT INTO faq (id, question, answer, order_number, program_id)
VALUES
    (1, 'FAQ for Liveclass 1', 'Answer to FAQ for Liveclass 1', 1, 1),
    (2, 'FAQ for Liveclass 2', 'Answer to FAQ for Liveclass 2', 2, 1),
    (3, 'FAQ for Liveclass 3', 'Answer to FAQ for Liveclass 3', 3, 1),
    (4, 'FAQ for Challenge 1', 'Answer to FAQ for Challenge 1', 1, 1),
    (5, 'FAQ for Challenge 2', 'Answer to FAQ for Challenge 2', 2, 1),
    (6, 'FAQ for Challenge 3', 'Answer to FAQ for Challenge 3', 3, 1),
    (7, 'FAQ for Challenge 4', 'Answer to FAQ for Challenge 4', 4, 1);

-- Insert Lecturer records
INSERT INTO lecturer (id, name, career, content, image_url, template_type, program_id)
VALUES
    (1, 'Lecturer 1', '10 years experience in Java', 'Expert in Java and Spring', 'https://lecturer_image_url_1', 'TYPE_A', 1),
    (2, 'Lecturer 2', '8 years experience in Python', 'Expert in Python and Django', 'https://lecturer_image_url_2', 'TYPE_A', 2),
    (3, 'Lecturer 3', '12 years experience in Web Development', 'Full-stack web developer', 'https://lecturer_image_url_3', 'TYPE_A', 3),
    (4, 'Lecturer 4', '15 years experience in Data Science', 'Expert in Data Science and AI', 'https://lecturer_image_url_4', 'TYPE_B', 4),
    (5, 'Lecturer 5', '7 years experience in Mobile Development', 'Expert in iOS and Android', 'https://lecturer_image_url_5', 'TYPE_B', 5),
    (6, 'Lecturer 6', '10 years experience in Cloud Computing', 'Expert in AWS and Azure', 'https://lecturer_image_url_6', 'TYPE_B', 6),
    (7, 'Lecturer 7', '9 years experience in DevOps', 'Expert in CI/CD and Automation', 'https://lecturer_image_url_7', 'TYPE_B', 7);

-- Insert RecommendedProgram records
INSERT INTO recommended_program (id, recommended_program_id, program_id)
VALUES
    (1, 2, 1),
    (2, 3, 1),
    (3, 1, 2),
    (4, 3, 2),
    (5, 1, 3),
    (6, 2, 3),
    (7, 5, 4),
    (8, 6, 4),
    (9, 4, 5),
    (10, 6, 5),
    (11, 4, 6),
    (12, 5, 6),
    (13, 7, 6),
    (14, 4, 7),
    (15, 5, 7);


-- Insert Hooking records
INSERT INTO hooking (id, title, pre_title, tag_title,  content, image_url, template_type, order_number, program_id)
VALUES
    (1, 'Hooking for Liveclass 1', 'Pre Title' , 'Tag Title','Hooking content for Liveclass 1', '', 'TYPE_A', 1, 1),
    (2, 'Hooking for Liveclass 2', 'Pre Title', 'Pre Title','Hooking content for Liveclass 2', '', 'TYPE_A', 2, 1),
    (3, 'Hooking for Liveclass 3','Pre Title' ,'Pre Title','Hooking content for Liveclass 3', '', 'TYPE_A', 3, 1),
    (5, 'Hooking for Challenge 2','Pre Title' , 'Pre Title','Hooking content for Challenge 2', 'https://hooking_image_url_1', 'image', 2, 1),
    (6, 'Hooking for Challenge 3','Pre Title' ,'Pre Title','Hooking content for Challenge 3', 'https://hooking_image_url_2', 'image', 3, 1),
    (7, 'Hooking for Challenge 4', 'Pre Title', 'Pre Title','Hooking content for Challenge 4', 'https://hooking_image_url_3', 'image', 1, 2);


-- Insert HookingImage records
INSERT INTO hooking_image (
    id,
    image_url,
    order_number,
    hooking_id
)
VALUES
    (1, 'https://image_url_1', 1, 1),
    (2, 'https://image_url_2', 2, 1),
    (3, 'https://image_url_3', 3, 1);

-- Insert Description records
INSERT INTO description (id, title, content, image_url, template_type, order_number, program_id)
VALUES
    (1, 'Description for Liveclass 1', 'Detailed description of Liveclass 1', '',  'TYPE_A', 1, 1),
    (2, 'Description for Liveclass 2', 'Detailed description of Liveclass 2', '',  'TYPE_A', 2, 1),
    (3, 'Description for Liveclass 3', 'Detailed description of Liveclass 3', '',  'TYPE_A', 3, 1),
    (5, 'Description for Challenge 2', 'Detailed description of Challenge 2', 'https://desc_image_url_5', 'image', 2, 1),
    (6, 'Description for Challenge 3', 'Detailed description of Challenge 3', 'https://desc_image_url_6', 'image', 3, 1),
    (7, 'Description for Challenge 4', 'Detailed description of Challenge 4', 'https://desc_image_url_7', 'image', 4, 1);

INSERT INTO hashtag (id, hashtag,order_number, description_id)
VALUES
    (1, 'Tag1', 1 ,1),
    (2, 'Tag2', 2 ,1),
    (3, 'Tag3', 3 ,1),
    (4, 'Tag4', 4 ,1),
    (5, 'Tag1', 1 ,2),
    (6, 'Tag2', 2 ,2),
    (7, 'Tag3', 3 ,2),
    (8, 'Tag4', 4 ,2),
    (9, 'Tag1', 1 ,3),
    (10, 'Tag2',2 ,3),
    (11, 'Tag3',3 ,3),
    (12, 'Tag4',4 ,3);
-- Insert DescriptionImage records
INSERT INTO description_image (
    id,
    image_url,
    order_number,
    description_id
)
VALUES
    (1, 'https://desc_image_url_1', 1, 1),
    (2, 'https://desc_image_url_2', 2, 1),
    (3, 'https://desc_image_url_3', 1, 1);
