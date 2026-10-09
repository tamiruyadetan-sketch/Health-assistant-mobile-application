package com.example.diseaseinformationhealthassistantmobileapplication.data

object DiseaseRepository {
    val diseasesEn = listOf(
        // --- Original diseases ---
        Disease(
            id = "heart_hypertension_en",
            name = "Hypertension (High Blood Pressure)",
            category = "Heart",
            definition = "Hypertension is a condition where the force of the blood against your artery walls is consistently too high.",
            symptoms = listOf("Severe headaches", "Shortness of breath", "Nosebleeds", "Fatigue or confusion", "Chest pain", "Irregular heartbeat"),
            causes = listOf("High salt intake", "Obesity", "Lack of exercise", "Smoking", "Genetics", "Chronic stress"),
            prevention = listOf("Reduce salt", "Regular exercise (30m daily)", "Maintain healthy weight", "Quit smoking", "Manage stress"),
            safetyPractices = listOf("Monitor blood pressure daily", "Take medication exactly as prescribed", "Avoid heavy lifting if symptomatic"),
            foodGuidance = "Eat potassium-rich foods (bananas, beans). Avoid processed snacks and high-sodium foods.",
            medicines = listOf("Amlodipine", "Lisinopril", "Hydrochlorothiazide"),
            medicineGuide = "Take daily at the same time. Never skip doses without consulting your doctor.",
            language = "en"
        ),
        Disease(
            id = "heart_attack_en",
            name = "Heart Attack",
            category = "Heart",
            definition = "A heart attack occurs when blood flow to the heart is blocked, usually by a buildup of fat and cholesterol.",
            symptoms = listOf("Chest pressure or pain", "Pain spreading to neck or arm", "Cold sweat", "Nausea", "Shortness of breath"),
            causes = listOf("Coronary artery disease", "High cholesterol", "Smoking", "High blood pressure"),
            prevention = listOf("Healthy diet", "Active lifestyle", "Managing cholesterol", "No smoking"),
            safetyPractices = listOf("Call 991 immediately if symptoms occur", "Rest and stay calm while waiting for help"),
            foodGuidance = "Avoid saturated fats. Eat more fish, nuts, and whole grains.",
            medicines = listOf("Aspirin", "Nitroglycerin"),
            medicineGuide = "Medicines are used for immediate relief and long-term prevention.",
            language = "en"
        ),
        Disease(
            id = "gastritis_en",
            name = "Gastritis",
            category = "Digestive",
            definition = "Gastritis is inflammation of the stomach lining, often caused by infection, pain relievers, or excessive alcohol.",
            symptoms = listOf("Upper abdominal pain or burning", "Nausea and vomiting", "Feeling of fullness in the upper abdomen", "Bloating", "Indigestion"),
            causes = listOf("Helicobacter pylori (H. pylori) infection", "Regular use of pain relievers (NSAIDs)", "Excessive alcohol", "Stress", "Bile reflux", "Autoimmune conditions"),
            prevention = listOf("Practice good hygiene and handwashing", "Use pain relievers cautiously and as directed", "Limit alcohol", "Eat smaller, more frequent meals", "Manage stress"),
            safetyPractices = listOf("Avoid NSAIDs if you have a history of stomach ulcers", "Avoid smoking", "Limit alcohol", "Seek medical care for severe or persistent abdominal pain", "Complete prescribed treatment for H. pylori"),
            foodGuidance = "Eat small, frequent meals that are gentle on the stomach. Avoid spicy, acidic, or fried foods and caffeine. Include soothing foods like oatmeal, bananas, and yogurt. Avoid eating late at night.",
            medicines = listOf("Antacids (Maalox, Tums)", "H2 blockers (Famotidine)", "Proton pump inhibitors (Omeprazole, Pantoprazole)", "Antibiotics (for H. pylori infection)"),
            medicineGuide = "Take acid-reducing medicines as prescribed, often before meals. Complete the full course of antibiotics if H. pylori is found. Avoid self-medicating with NSAIDs.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Erosive Gastritis", description = "Stomach lining wears away, causing erosions or ulcers."),
                DiseaseType(name = "Non-Erosive Gastritis", description = "Inflammation of the stomach lining without erosions or ulcers.")
            )
        ),
        Disease(
            id = "peptic_ulcer_en",
            name = "Peptic Ulcer Disease",
            category = "Digestive",
            definition = "Peptic ulcer disease is the presence of open sores on the inside lining of the stomach (gastric ulcer) or the upper part of the small intestine (duodenal ulcer).",
            symptoms = listOf("Burning stomach pain", "Feeling of fullness, bloating, or burping", "Fatty-food intolerance", "Heartburn", "Nausea", "Dark or tarry stools", "Vomiting blood"),
            causes = listOf("H. pylori infection", "Regular use of NSAIDs", "Excessive alcohol", "Stress", "Smoking"),
            prevention = listOf("Protect yourself from H. pylori infection", "Use pain relievers with caution", "Limit alcohol", "Do not smoke", "Manage stress"),
            safetyPractices = listOf("Seek immediate care for sharp, severe abdominal pain", "Report vomiting blood or material that looks like coffee grounds", "Report black or bloody stools", "Avoid NSAIDs while healing"),
            foodGuidance = "Eat regular, balanced meals to help neutralize stomach acid. Avoid spicy foods, acidic foods, caffeine, and alcohol if they worsen symptoms. Include fiber-rich foods and probiotics (yogurt, kefir).",
            medicines = listOf("Proton pump inhibitors (Omeprazole, Esomeprazole)", "H2 blockers (Famotidine)", "Antacids", "Antibiotics (for H. pylori)"),
            medicineGuide = "Take PPIs and H2 blockers before meals as prescribed. Complete the full course of antibiotics if H. pylori is present. Avoid NSAIDs and smoking during treatment.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Gastric Ulcer", description = "An open sore on the inside lining of the stomach."),
                DiseaseType(name = "Duodenal Ulcer", description = "An open sore on the inside of the upper part of the small intestine (duodenum).")
            )
        ),
        Disease(
            id = "gerd_en",
            name = "GERD (Acid Reflux)",
            category = "Digestive",
            definition = "GERD is a chronic condition in which stomach acid frequently flows back into the tube connecting your mouth and stomach (esophagus).",
            symptoms = listOf("Heartburn (burning chest pain)", "Regurgitation of food or sour liquid", "Difficulty swallowing", "Chest pain", "Dry cough", "Hoarseness or sore throat", "Sensation of a lump in the throat", "Regurgitation of food or sour liquid at night"),
            causes = listOf("Weak lower esophageal sphincter", "Hiatal hernia", "Obesity", "Pregnancy", "Smoking", "Certain medications", "Eating large meals or lying down after eating"),
            prevention = listOf("Eat smaller, more frequent meals", "Avoid lying down after eating", "Maintain a healthy weight", "Avoid trigger foods (spicy, fatty, acidic)", "Quit smoking", "Elevate the head of your bed"),
            safetyPractices = listOf("Seek medical care for severe chest pain", "Report difficulty or painful swallowing", "Report unexplained weight loss", "Report vomiting blood or black stools", "Avoid eating 2-3 hours before bedtime"),
            foodGuidance = "Avoid trigger foods such as spicy, fatty, or acidic foods, chocolate, caffeine, and mint. Eat smaller meals and avoid eating within 2-3 hours of bedtime. Maintain a healthy weight. Choose lean proteins, vegetables, and whole grains.",
            medicines = listOf("Antacids (Aluminum hydroxide, Magnesium hydroxide)", "H2 blockers (Famotidine, Cimetidine)", "Proton pump inhibitors (Omeprazole, Lansoprazole)", "Foaming agents (Gaviscon)"),
            medicineGuide = "Take PPIs 30-60 minutes before meals. Use antacids for quick relief as directed. Long-term use should be reviewed by a doctor, especially in older adults.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Non-Erosive Reflux Disease (NERD)", description = "Heartburn symptoms without visible damage to the esophagus."),
                DiseaseType(name = "Erosive Esophagitis", description = "Inflammation and damage to the esophagus from stomach acid.")
            )
        ),
        Disease(
            id = "ibs_en",
            name = "Irritable Bowel Syndrome (IBS)",
            category = "Digestive",
            definition = "IBS is a common disorder affecting the large intestine, causing cramping, abdominal pain, bloating, gas, and diarrhea or constipation or both.",
            symptoms = listOf("Abdominal pain or cramping", "Bloating and gas", "Diarrhea, constipation, or alternating between both", "Mucus in the stool", "Feeling of incomplete evacuation", "Bowel habits changes related to stress or meals"),
            causes = listOf("Changes in gut bacteria", "Intestinal inflammation", "Severe infection (gastroenteritis)", "Nervous system abnormalities", "Food triggers", "Stress"),
            prevention = listOf("Identify and avoid trigger foods", "Manage stress", "Eat regular, balanced meals", "Get enough fiber", "Stay physically active", "Keep a food and symptom diary"),
            safetyPractices = listOf("Seek medical care for unexplained weight loss", "Report blood in the stool", "Report persistent vomiting", "Report symptoms that wake you at night", "Report worsening symptoms despite treatment"),
            foodGuidance = "Follow a low-FODMAP diet to identify trigger foods. Eat regular meals and avoid large portions. Increase soluble fiber (oats, bananas, carrots). Stay hydrated. Limit gas-producing foods (beans, cabbage) and artificial sweeteners.",
            medicines = listOf("Antispasmodics (for cramping)", "Laxatives (for constipation)", "Anti-diarrheal (Loperamide)", "Tricyclic antidepressants (low dose, for pain)", "Rifaximin (for bloating)"),
            medicineGuide = "Treat symptoms with the appropriate medicine: laxatives or anti-diarrheals for bowel habit changes. Antispasmodics may be taken before meals. Discuss low-dose antidepressants for pain with your doctor.",
            language = "en",
            types = listOf(
                DiseaseType(name = "IBS with Constipation (IBS-C)", description = "Predominant symptom is constipation."),
                DiseaseType(name = "IBS with Diarrhea (IBS-D)", description = "Predominant symptom is diarrhea."),
                DiseaseType(name = "Mixed IBS (IBS-M)", description = "Alternating constipation and diarrhea.")
            )
        ),
        Disease(
            id = "arthritis_en",
            name = "Arthritis",
            category = "Musculoskeletal",
            definition = "Arthritis is inflammation of one or more joints, causing pain, swelling, and stiffness that can worsen with age.",
            symptoms = listOf("Joint pain", "Stiffness, especially in the morning", "Swelling around the joint", "Redness and warmth of the joint", "Decreased range of motion", "Fatigue", "Loss of flexibility"),
            causes = listOf("Osteoarthritis (wear-and-tear of cartilage)", "Rheumatoid arthritis (autoimmune)", "Gout (uric acid crystals)", "Infections (septic arthritis)", "Genetics", "Age", "Obesity", "Previous joint injury", "Smoking"),
            prevention = listOf("Maintain a healthy weight", "Stay physically active with low-impact exercise", "Protect joints from injury", "Strengthen muscles around joints", "Eat an anti-inflammatory diet", "Avoid smoking", "Limit repetitive joint stress"),
            safetyPractices = listOf("Apply heat for stiffness and cold for swelling", "Use assistive devices if needed", "Avoid prolonged inactivity", "Take medicines exactly as prescribed", "Report sudden severe joint swelling or fever to a doctor"),
            foodGuidance = "Eat an anti-inflammatory diet rich in omega-3 fatty acids (fatty fish, walnuts, flaxseed), fruits, vegetables, and whole grains. Limit red meat, refined sugar, alcohol, and processed foods. Maintain a healthy weight to reduce joint load.",
            medicines = listOf("Pain relievers (Acetaminophen)", "NSAIDs (Ibuprofen, Naproxen)", "Disease-modifying antirheumatic drugs (Methotrexate)", "Corticosteroids", "Biologics (for rheumatoid arthritis)", "Gout medicines (Allopurinol, Colchicine)"),
            medicineGuide = "Take pain and anti-inflammatory medicines as prescribed. Do not exceed recommended doses of NSAIDs. Disease-modifying drugs require regular blood monitoring. Report side effects to your doctor.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Osteoarthritis", description = "Most common type, caused by gradual wear-and-tear of joint cartilage."),
                DiseaseType(name = "Rheumatoid Arthritis", description = "An autoimmune disorder where the immune system attacks the joints, often affecting both sides of the body."),
                DiseaseType(name = "Gout", description = "Sudden, severe attacks of joint pain caused by uric acid crystals, often in the big toe."),
                DiseaseType(name = "Infectious Arthritis", description = "Joint infection caused by bacteria or viruses, requiring urgent medical treatment.")
            )
        ),
        Disease(
            id = "back_pain_en",
            name = "Back Pain (Lower Back Pain)",
            category = "Musculoskeletal",
            definition = "Back pain is one of the most common reasons for missed work and disability, caused by strain, poor posture, or underlying spinal conditions.",
            symptoms = listOf("Dull, aching pain in the back", "Stiffness or tightness", "Sharp, shooting pain", "Pain that radiates down the leg (sciatica)", "Limited range of motion", "Muscle spasms", "Pain that worsens with bending or lifting"),
            causes = listOf("Muscle or ligament strain", "Heavy lifting or sudden movement", "Poor posture or prolonged sitting", "Herniated or bulging disc", "Scoliosis", "Osteoporosis", "Arthritis of the spine", "Obesity", "Lack of exercise", "Stress and poor sleep"),
            prevention = listOf("Practice good posture", "Exercise and stretch regularly", "Strengthen core muscles", "Lift with proper technique (bend knees, not waist)", "Maintain a healthy weight", "Avoid prolonged sitting", "Use a supportive chair and mattress", "Quit smoking"),
            safetyPractices = listOf("Seek urgent care for loss of bladder/bowel control or numbness in the groin", "Report weakness in both legs", "Report back pain after a fall or accident", "Avoid bed rest for long periods", "Apply heat or cold as tolerated"),
            foodGuidance = "Eat a balanced diet rich in calcium and vitamin D (dairy, leafy greens, fortified foods) for bone health. Include anti-inflammatory foods like fatty fish, nuts, and vegetables. Stay hydrated and maintain a healthy weight.",
            medicines = listOf("Pain relievers (Acetaminophen)", "NSAIDs (Ibuprofen, Naproxen)", "Muscle relaxants", "Topical pain relievers", "Antidepressants (for chronic nerve pain)", "Corticosteroid injections"),
            medicineGuide = "Take pain medicines as directed for short periods. NSAIDs should be used cautiously in older adults and people with kidney or stomach problems. Chronic pain may need a multidisciplinary plan.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Acute Back Pain", description = "Sudden pain lasting less than 6 weeks, usually from muscle strain. Often improves on its own."),
                DiseaseType(name = "Chronic Back Pain", description = "Pain lasting more than 12 weeks, sometimes due to disc or joint problems."),
                DiseaseType(name = "Sciatica", description = "Pain radiating along the sciatic nerve, from the lower back down one leg."),
                DiseaseType(name = "Herniated Disc", description = "A disc that bulges or ruptures and presses on nearby nerves.")
            )
        ),
        Disease(
            id = "osteoporosis_en",
            name = "Osteoporosis",
            category = "Musculoskeletal",
            definition = "Osteoporosis is a condition that weakens bones, making them fragile and more likely to break, often with no symptoms until a fracture occurs.",
            symptoms = listOf("Usually no symptoms in early stages", "Back pain caused by fractured vertebra", "Loss of height over time", "Stooped posture", "Bone fractures from minor falls", "Receding gums", "Weak grip strength"),
            causes = listOf("Age and hormonal changes (especially after menopause)", "Low calcium intake", "Vitamin D deficiency", "Lack of physical activity", "Smoking", "Excessive alcohol", "Long-term corticosteroid use", "Family history", "Low body weight", "Certain medical conditions and medicines"),
            prevention = listOf("Get enough calcium and vitamin D", "Weight-bearing and muscle-strengthening exercise", "Avoid smoking", "Limit alcohol", "Prevent falls at home", "Maintain a healthy body weight", "Have bone density checked if at risk"),
            safetyPractices = listOf("Prevent falls (remove loose rugs, improve lighting)", "Use good posture and body mechanics", "Take supplements as recommended", "Attend regular bone density checks", "Report sudden severe back pain to a doctor"),
            foodGuidance = "Eat calcium-rich foods (milk, yogurt, cheese, leafy greens, sardines) and vitamin D sources (fatty fish, egg yolks, fortified foods). Limit caffeine, salt, and alcohol. Maintain adequate protein intake.",
            medicines = listOf("Calcium and vitamin D supplements", "Bisphosphonates (Alendronate, Risedronate)", "Calcitonin", "Monoclonal antibodies (Denosumab)", "Hormone therapy", "Bone-building medicines (Teriparatide)"),
            medicineGuide = "Take calcium and vitamin D as advised, often with food. Take bisphosphonates on an empty stomach with water and stay upright for 30 minutes. Regular bone density monitoring is recommended.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Primary Osteoporosis", description = "Related to aging and hormonal changes, the most common form, especially after menopause."),
                DiseaseType(name = "Secondary Osteoporosis", description = "Caused by another condition or medication, such as long-term steroid use."),
                DiseaseType(name = "Osteopenia", description = "Lower than normal bone density but not yet osteoporosis. A warning stage.")
            )
        ),
        Disease(
            id = "skin_eczema_en",
            name = "Eczema (Dermatitis)",
            category = "Skin",
            definition = "Eczema is a condition that makes your skin red and itchy, common in children but appearing at any age.",
            symptoms = listOf("Dry skin", "Severe itching", "Red to brownish patches", "Small raised bumps", "Cracked or scaly skin"),
            causes = listOf("Genetics", "Allergens (soaps, pollen)", "Immune system overreaction", "Stress"),
            prevention = listOf("Moisturize skin daily", "Use mild, fragrance-free soaps", "Identify and avoid triggers"),
            safetyPractices = listOf("Do not scratch affected areas", "Apply cool compresses for itching", "Wear soft cotton fabrics"),
            foodGuidance = "Anti-inflammatory foods like turmeric and fatty fish may help. Stay hydrated.",
            medicines = listOf("Hydrocortisone cream", "Antihistamines"),
            medicineGuide = "Apply topical treatments to clean, slightly damp skin for best results.",
            language = "en"
        ),
        Disease(
            id = "skin_acne_en",
            name = "Acne",
            category = "Skin",
            definition = "Acne occurs when hair follicles become plugged with oil and dead skin cells.",
            symptoms = listOf("Whiteheads", "Blackheads", "Small red bumps", "Pimples", "Large painful lumps"),
            causes = listOf("Excess oil production", "Bacteria", "Hormonal changes", "Clogged pores"),
            prevention = listOf("Wash face twice daily", "Avoid touching face", "Use oil-free skincare"),
            safetyPractices = listOf("Do not squeeze or pop pimples", "Clean phone screens regularly"),
            foodGuidance = "Reducing dairy and high-sugar foods may improve skin for some.",
            medicines = listOf("Benzoyl peroxide", "Salicylic acid", "Retinoids"),
            medicineGuide = "Apply acne treatments to the entire affected area, not just the spots.",
            language = "en"
        ),
        Disease(
            id = "blood_anemia_en",
            name = "Anemia (Iron Deficiency)",
            category = "Blood",
            definition = "Anemia occurs when your blood lacks enough healthy red blood cells to carry oxygen to your tissues.",
            symptoms = listOf("Persistent fatigue", "Weakness", "Pale skin", "Dizziness", "Shortness of breath", "Cold hands/feet"),
            causes = listOf("Lack of iron in diet", "Blood loss", "Pregnancy", "Chronic infections"),
            prevention = listOf("Eat iron-rich foods", "Consume Vitamin C to aid absorption", "Regular checkups"),
            safetyPractices = listOf("Rest frequently", "Move slowly if feeling dizzy", "Monitor iron levels regularly"),
            foodGuidance = "Eat red meat, beans, lentils, and spinach. Pair with citrus for better absorption.",
            medicines = listOf("Iron supplements", "Vitamin B12", "Folic acid"),
            medicineGuide = "Take iron with water or juice on an empty stomach for best absorption.",
            language = "en"
        ),
        Disease(
            id = "malaria_en",
            name = "Malaria",
            category = "Infectious",
            definition = "Malaria is a life-threatening disease transmitted through the bites of infected mosquitoes.",
            symptoms = listOf("Fever", "Chills", "Headache", "Muscle aches"),
            causes = listOf("Plasmodium parasites", "Mosquito bites"),
            prevention = listOf("Use bed nets", "Apply repellent", "Clear stagnant water"),
            safetyPractices = listOf("Seek medical care for fever", "Finish all antimalarial medicine"),
            foodGuidance = "Drink safe water. Eat iron-rich foods.",
            medicines = listOf("Artemether-lumefantrine"),
            medicineGuide = "Follow the full course prescribed by your doctor.",
            language = "en"
        ),
        Disease(
            id = "hiv_en",
            name = "HIV/AIDS",
            category = "Infectious",
            definition = "HIV is a virus that attacks the immune system. If not treated, it can lead to AIDS.",
            symptoms = listOf("Fever", "Fatigue", "Swollen lymph nodes", "Weight loss"),
            causes = listOf("Unprotected sexual contact", "Sharing needles"),
            prevention = listOf("Consistent condom use", "Regular testing"),
            safetyPractices = listOf("Start ART medication early", "Take daily medication at the same time"),
            foodGuidance = "Eat plenty of protein and wash all produce carefully.",
            medicines = listOf("Tenofovir", "Lamivudine"),
            medicineGuide = "ART must be taken daily to remain effective.",
            language = "en"
        ),
        Disease(
            id = "diabetes_en",
            name = "Diabetes",
            category = "Chronic",
            definition = "Diabetes is a condition characterized by high blood glucose levels.",
            symptoms = listOf("Excessive thirst", "Frequent urination", "Blurred vision", "Fatigue"),
            causes = listOf("Insulin resistance", "Genetics", "Obesity"),
            prevention = listOf("Maintain healthy weight", "Regular exercise", "Limit sugar intake"),
            safetyPractices = listOf("Monitor blood sugar", "Check feet daily", "Follow meal plan"),
            foodGuidance = "Choose whole grains and vegetables. Avoid sugary drinks.",
            medicines = listOf("Metformin", "Insulin"),
            medicineGuide = "Follow your dosing schedule strictly.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Type 1 Diabetes", description = "An autoimmune condition where the pancreas produces little or no insulin."),
                DiseaseType(name = "Type 2 Diabetes", description = "The most common form, where the body becomes resistant to insulin."),
                DiseaseType(name = "Gestational Diabetes", description = "Diabetes that develops during pregnancy.")
            )
        ),
        // --- New diseases ---
        Disease(
            id = "cancer_en",
            name = "Cancer",
            category = "Chronic",
            definition = "Cancer is a group of diseases involving abnormal cell growth with the potential to invade or spread to other parts of the body.",
            symptoms = listOf("Unexplained weight loss", "Fatigue", "Lumps or thickening", "Changes in bowel or bladder habits", "Persistent cough", "Difficulty swallowing", "Unusual bleeding or discharge", "Skin changes"),
            causes = listOf("Tobacco use", "Excessive alcohol", "Poor diet", "Physical inactivity", "Obesity", "Sun exposure", "Infections (HPV, Hepatitis)", "Genetic factors", "Environmental carcinogens", "Age"),
            prevention = listOf("Avoid tobacco in all forms", "Limit alcohol consumption", "Maintain a healthy weight", "Eat a diet rich in fruits and vegetables", "Stay physically active", "Protect skin from sun", "Get vaccinated (HPV, Hepatitis B)", "Regular cancer screenings", "Avoid risky behaviors"),
            safetyPractices = listOf("Report unusual symptoms to a doctor promptly", "Follow recommended screening schedules", "Know your family history", "Practice sun safety", "Avoid exposure to carcinogens"),
            foodGuidance = "Eat a plant-based diet rich in fruits, vegetables, whole grains, and legumes. Limit red and processed meats. Include antioxidant-rich foods like berries, leafy greens, and nuts.",
            medicines = listOf("Chemotherapy agents", "Immunotherapy drugs", "Targeted therapy", "Hormone therapy", "Radiation therapy"),
            medicineGuide = "Cancer treatment is highly individualized. Follow your oncologist's treatment plan exactly. Report all side effects to your medical team.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Carcinomas", description = "Cancers that begin in the skin or tissues lining organs (lung, breast, colon, prostate). Most common type."),
                DiseaseType(name = "Sarcomas", description = "Cancers that begin in bone, cartilage, fat, muscle, or blood vessels."),
                DiseaseType(name = "Leukemias", description = "Cancers of the blood-forming tissues, including bone marrow and lymphatic system."),
                DiseaseType(name = "Lymphomas", description = "Cancers that begin in the lymphatic system, part of the body's immune system.")
            )
        ),
        Disease(
            id = "heart_disease_en",
            name = "Heart Disease (Coronary Artery Disease)",
            category = "Heart",
            definition = "Heart disease refers to various conditions affecting the heart, including coronary artery disease, arrhythmias, and heart failure.",
            symptoms = listOf("Chest pain, pressure, or discomfort (angina)", "Shortness of breath", "Pain in neck, jaw, throat, upper belly, or back", "Pain, numbness, or weakness in legs or arms", "Fatigue", "Heart palpitations", "Swelling in legs, ankles, or feet", "Dizziness or lightheadedness"),
            causes = listOf("Coronary artery disease (plaque buildup)", "High cholesterol", "High blood pressure", "Smoking", "Diabetes", "Obesity", "Unhealthy diet", "Physical inactivity", "Excessive alcohol use", "Family history", "Age", "Stress"),
            prevention = listOf("Eat a heart-healthy diet", "Stay physically active (150 min/week)", "Maintain healthy weight", "Quit smoking", "Limit alcohol", "Manage stress", "Control blood pressure and cholesterol", "Manage diabetes", "Get regular checkups"),
            safetyPractices = listOf("Know the warning signs of a heart attack", "Call emergency services immediately if symptoms occur", "Take all medications as prescribed", "Attend cardiac rehabilitation if recommended", "Monitor weight daily for fluid retention", "Follow up regularly with your cardiologist"),
            foodGuidance = "Eat a Mediterranean-style diet: fish (especially fatty fish like salmon), olive oil, nuts, whole grains, fruits, and vegetables. Limit saturated fats, trans fats, cholesterol, sodium, and added sugars.",
            medicines = listOf("Aspirin (antiplatelet)", "Beta blockers", "Statins", "ACE inhibitors", "Calcium channel blockers", "Diuretics (water pills)", "Nitroglycerin"),
            medicineGuide = "Take all heart medications exactly as prescribed. Do not stop any medication without consulting your doctor. Some medications require periodic blood tests.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Coronary Artery Disease", description = "Narrowing of the coronary arteries due to plaque buildup, reducing blood flow to the heart muscle."),
                DiseaseType(name = "Arrhythmia", description = "Abnormal heart rhythms - the heart beats too fast, too slow, or irregularly."),
                DiseaseType(name = "Heart Failure", description = "The heart cannot pump enough blood to meet the body's needs."),
                DiseaseType(name = "Valvular Heart Disease", description = "Damage or defect in one of the four heart valves.")
            )
        ),
        Disease(
            id = "brain_disease_en",
            name = "Brain Disease (Neurological Disorders)",
            category = "Nervous",
            definition = "Brain diseases encompass a range of disorders affecting the brain, including stroke, epilepsy, Alzheimer's disease, Parkinson's disease, and other neurological conditions.",
            symptoms = listOf("Severe headaches or migraines", "Confusion or memory problems", "Seizures", "Loss of balance or coordination", "Numbness or tingling", "Muscle weakness", "Vision problems", "Speech difficulties", "Changes in mood or behavior", "Dizziness", "Loss of consciousness"),
            causes = listOf("Genetic factors", "Infections (meningitis, encephalitis)", "Traumatic brain injury", "Stroke (blood flow interruption)", "Autoimmune disorders", "Degenerative processes (Alzheimer's, Parkinson's)", "Tumors", "Environmental toxins", "Poor nutrition", "Chronic stress", "Sleep disorders"),
            prevention = listOf("Protect head from injury (wear helmets)", "Manage blood pressure", "Maintain a healthy diet", "Exercise regularly", "Get adequate sleep", "Manage stress", "Stay mentally active", "Avoid excessive alcohol and drugs", "Treat infections promptly", "Control diabetes and cholesterol"),
            safetyPractices = listOf("Seek immediate emergency care for sudden severe headaches, confusion, or weakness", "Follow medication schedules strictly for seizure disorders", "Create a safe environment to prevent falls", "Wear medical ID if you have a seizure disorder", "Avoid driving if your condition is uncontrolled", "Keep regular neurology appointments"),
            foodGuidance = "Eat a brain-healthy diet rich in omega-3 fatty acids (fish, walnuts, flaxseeds), antioxidants (berries, leafy greens), and B vitamins. Limit processed foods, trans fats, and excessive sugar. Consider the Mediterranean or MIND diet for cognitive health.",
            medicines = listOf("Anticonvulsants (for epilepsy)", "Antipsychotics", "Antidepressants", "Cholinesterase inhibitors (for Alzheimer's)", "Dopamine agonists (for Parkinson's)", "Anticoagulants (for stroke prevention)", "Corticosteroids (for inflammation)"),
            medicineGuide = "Brain medications must be taken exactly as prescribed. Never stop seizure or psychiatric medications abruptly. Report any side effects, especially changes in mood or behavior.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Stroke", description = "Sudden disruption of blood flow to the brain, causing brain cell death. Can be ischemic (blockage) or hemorrhagic (bleeding)."),
                DiseaseType(name = "Alzheimer's Disease", description = "Progressive neurodegenerative disease causing memory loss, cognitive decline, and behavioral changes."),
                DiseaseType(name = "Parkinson's Disease", description = "Progressive disorder affecting movement, causing tremors, stiffness, and balance problems."),
                DiseaseType(name = "Epilepsy", description = "A neurological disorder characterized by recurrent, unprovoked seizures.")
            )
        ),
        Disease(
            id = "lung_disease_en",
            name = "Lung Disease (Respiratory Disorders)",
            category = "Respiratory",
            definition = "Lung diseases affect the respiratory system, including COPD, asthma, pneumonia, pulmonary fibrosis, and lung cancer.",
            symptoms = listOf("Shortness of breath", "Persistent cough", "Wheezing", "Chest pain or tightness", "Coughing up mucus or blood", "Fatigue", "Frequent respiratory infections", "Swelling in ankles, feet, or legs", "Blue tint to lips or fingernails (cyanosis)", "Rapid, shallow breathing"),
            causes = listOf("Smoking (primary cause of COPD and lung cancer)", "Air pollution", "Occupational exposures (dust, chemicals)", "Infections (bacterial, viral, fungal)", "Genetic factors (alpha-1 antitrypsin deficiency)", "Allergens", "Autoimmune conditions", "Age", "Poor indoor air quality", "Secondhand smoke"),
            prevention = listOf("Quit smoking and avoid secondhand smoke", "Test home for radon", "Avoid air pollution when possible", "Practice good hygiene to prevent infections", "Get vaccinated (flu, pneumonia)", "Use protective equipment at work", "Exercise regularly to strengthen lungs", "Maintain healthy weight", "Manage allergies"),
            safetyPractices = listOf("Seek immediate care for severe shortness of breath", "Use inhalers correctly as prescribed", "Carry rescue inhaler at all times if asthmatic", "Avoid triggers (smoke, dust, allergens)", "Get annual flu vaccine", "Monitor oxygen levels if recommended", "Practice breathing exercises"),
            foodGuidance = "Eat a balanced diet with adequate protein to maintain respiratory muscles. Include anti-inflammatory foods like fatty fish, turmeric, ginger, and leafy greens. Stay hydrated to thin mucus. Avoid gas-producing foods that can press on the diaphragm.",
            medicines = listOf("Bronchodilators (inhalers)", "Corticosteroids (inhaled or oral)", "Antibiotics (for bacterial infections)", "Antiviral medications", "Oxygen therapy", "Mucolytics", "Phosphodiesterase-4 inhibitors", "Biologic therapies (for severe asthma)"),
            medicineGuide = "Use inhalers exactly as prescribed - proper technique is essential. Rinse mouth after using steroid inhalers to prevent oral thrush. Never run out of rescue inhaler.",
            language = "en",
            types = listOf(
                DiseaseType(name = "COPD (Chronic Obstructive Pulmonary Disease)", description = "Progressive lung disease including emphysema and chronic bronchitis, mainly caused by smoking."),
                DiseaseType(name = "Asthma", description = "Chronic condition where airways narrow and swell, producing extra mucus and making breathing difficult."),
                DiseaseType(name = "Pneumonia", description = "Infection that inflames air sacs in one or both lungs, which may fill with fluid or pus."),
                DiseaseType(name = "Pulmonary Fibrosis", description = "Progressive scarring of lung tissue, making it harder to breathe.")
            )
        ),
        Disease(
            id = "tb_en",
            name = "Tuberculosis (TB)",
            category = "Infectious",
            definition = "Tuberculosis is a potentially serious infectious disease that mainly affects the lungs, caused by the bacterium Mycobacterium tuberculosis.",
            symptoms = listOf("Persistent cough (3+ weeks)", "Coughing up blood or sputum", "Chest pain", "Fatigue", "Fever", "Night sweats", "Unintended weight loss", "Loss of appetite", "Chills", "Shortness of breath"),
            causes = listOf("Mycobacterium tuberculosis bacteria", "Airborne transmission (inhaling droplets from infected person)", "Weakened immune system (HIV, diabetes, chemotherapy)", "Close contact with infected person", "Living in or traveling to high-prevalence areas", "Malnutrition", "Substance abuse", "Healthcare work"),
            prevention = listOf("Get BCG vaccine (in high-risk areas)", "Complete full course of TB treatment", "Cover mouth when coughing", "Ensure good ventilation", "Wear a mask if infectious", "Get tested if exposed", "Treat latent TB infection", "Maintain good nutrition and immune health"),
            safetyPractices = listOf("Complete the full course of antibiotics even if feeling better", "Cover mouth and nose when coughing or sneezing", "Dispose of tissues properly", "Ventilate rooms well", "Avoid close contact with others until non-infectious", "Follow up with sputum tests as scheduled", "Report any medication side effects to your doctor"),
            foodGuidance = "Eat a nutrient-rich diet with adequate protein (eggs, lean meat, beans, dairy), complex carbohydrates, and fresh fruits and vegetables. TB increases metabolic demand, so calorie intake may need to be higher. Vitamin D and zinc support immune function. Avoid alcohol during treatment as it can interact with TB medications.",
            medicines = listOf("Isoniazid (INH)", "Rifampin (RIF)", "Ethambutol", "Pyrazinamide", "Streptomycin (injectable)"),
            medicineGuide = "TB treatment requires taking multiple antibiotics for 6-9 months. Take all medications exactly as prescribed. Missing doses can lead to drug-resistant TB. Liver function must be monitored during treatment.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Latent TB Infection", description = "TB bacteria are present in the body but inactive. No symptoms and not contagious, but can become active later."),
                DiseaseType(name = "Active TB Disease", description = "TB bacteria are multiplying and attacking the body. Symptoms are present and the disease is contagious."),
                DiseaseType(name = "Miliary TB", description = "Rare form where TB bacteria spread throughout the body via the bloodstream."),
                DiseaseType(name = "Drug-Resistant TB", description = "TB that does not respond to standard medications, requiring longer treatment with second-line drugs.")
            )
        ),
        Disease(
            id = "pneumonia_en",
            name = "Pneumonia",
            category = "Infectious",
            definition = "Pneumonia is an infection that inflames the air sacs in one or both lungs, which may fill with fluid or pus.",
            symptoms = listOf("Cough (may produce phlegm)", "Fever, sweating, and shaking chills", "Shortness of breath", "Rapid, shallow breathing", "Chest pain that worsens when breathing or coughing", "Loss of appetite", "Fatigue", "Nausea and vomiting", "Confusion (especially in older adults)", "Bluish lips or nails (severe cases)"),
            causes = listOf("Bacteria (Streptococcus pneumoniae - most common)", "Viruses (influenza, RSV, coronavirus)", "Fungi (in people with weakened immune systems)", "Aspiration (inhaling food, liquid, or vomit)", "Weakened immune system", "Recent respiratory infection", "Chronic diseases (COPD, diabetes, heart disease)", "Smoking", "Age (very young or over 65)", "Hospitalization (especially on ventilators)"),
            prevention = listOf("Get vaccinated (pneumococcal, flu, COVID-19 vaccines)", "Wash hands frequently", "Don't smoke", "Maintain a healthy immune system", "Manage chronic conditions", "Avoid people who are sick", "Practice good hygiene", "Get adequate sleep and nutrition"),
            safetyPractices = listOf("Seek medical attention for high fever, difficulty breathing, or chest pain", "Complete full course of prescribed antibiotics", "Rest and stay hydrated", "Use a humidifier for comfort", "Monitor for worsening symptoms", "Isolate if contagious (viral pneumonia)", "Follow up with chest X-ray if recommended"),
            foodGuidance = "Eat warm, nutritious foods that are easy to digest. Include protein-rich foods (chicken soup, eggs, yogurt) to support healing. Drink plenty of fluids (water, herbal tea, clear broths) to stay hydrated and loosen mucus. Add anti-inflammatory foods like ginger and garlic. Avoid cold drinks and heavy, greasy meals.",
            medicines = listOf("Antibiotics (for bacterial pneumonia: Azithromycin, Amoxicillin, Levofloxacin)", "Antiviral medications (for viral pneumonia)", "Antifungal medications (for fungal pneumonia)", "Fever reducers/pain relievers (Acetaminophen, Ibuprofen)", "Cough medicine (as directed)", "Oxygen therapy (for severe cases)"),
            medicineGuide = "Take all antibiotics exactly as prescribed, even after feeling better. Stopping early can cause the infection to return and become resistant. For viral pneumonia, antibiotics won't help - rest and supportive care are key.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Bacterial Pneumonia", description = "Most common type, often caused by Streptococcus pneumoniae. Can occur after a cold or flu."),
                DiseaseType(name = "Viral Pneumonia", description = "Caused by viruses like influenza, RSV, or coronavirus. Often milder but can be serious."),
                DiseaseType(name = "Mycoplasma Pneumonia", description = "Also called 'walking pneumonia.' Milder form caused by Mycoplasma bacteria."),
                DiseaseType(name = "Aspiration Pneumonia", description = "Caused by inhaling food, liquid, or vomit into the lungs.")
            )
        ),
        Disease(
            id = "typhoid_en",
            name = "Typhoid Fever",
            category = "Infectious",
            definition = "Typhoid fever is a serious bacterial infection caused by Salmonella typhi, spread through contaminated food and water.",
            symptoms = listOf("High fever (up to 104°F/40°C)", "Weakness and fatigue", "Stomach pain", "Headache", "Loss of appetite", "Rash (rose spots on chest/abdomen)", "Constipation or diarrhea", "Cough", "Sweating", "Enlarged spleen or liver"),
            causes = listOf("Salmonella typhi bacteria", "Contaminated food or water", "Poor sanitation and hygiene", "Close contact with infected person", "Travel to endemic areas", "Carriers who handle food"),
            prevention = listOf("Get vaccinated before traveling to high-risk areas", "Drink only bottled or boiled water", "Avoid ice in drinks", "Eat only thoroughly cooked, hot food", "Avoid raw fruits and vegetables unless peeled", "Wash hands frequently with soap", "Choose restaurants carefully when traveling", "Practice good sanitation"),
            safetyPractices = listOf("Complete the full course of antibiotics", "Rest during acute illness", "Drink plenty of fluids to prevent dehydration", "Practice strict hand hygiene", "Avoid preparing food for others until cleared by a doctor", "Follow up with stool tests to confirm clearance", "Report any medication side effects"),
            foodGuidance = "Eat easily digestible, nutritious foods during recovery: boiled rice, bananas, toast, boiled potatoes, yogurt, and clear soups. Stay well hydrated with clean water, oral rehydration solutions, or coconut water. Avoid spicy, fatty, or heavily seasoned foods. Eat small, frequent meals. Avoid raw foods and unpasteurized dairy.",
            medicines = listOf("Ciprofloxacin (or other fluoroquinolones)", "Azithromycin", "Ceftriaxone (injectable)", "Cefixime", "Carbapenems (for resistant cases)"),
            medicineGuide = "Take antibiotics exactly as prescribed for the full course (usually 7-14 days). Resistance is common, so follow your doctor's choice of antibiotic. Stay home and avoid contact with others until cleared. Stool tests may be needed to confirm you're no longer a carrier.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Typhoid Fever (Enteric Fever)", description = "Systemic illness caused by Salmonella typhi, characterized by prolonged fever and systemic symptoms."),
                DiseaseType(name = "Paratyphoid Fever", description = "Similar to typhoid but caused by Salmonella paratyphi, usually milder."),
                DiseaseType(name = "Chronic Carrier State", description = "People who continue to harbor and shed bacteria after recovery, sometimes for years.")
            )
        ),
        Disease(
            id = "hepatitis_en",
            name = "Hepatitis (Liver Inflammation)",
            category = "Infectious",
            definition = "Hepatitis is inflammation of the liver, commonly caused by viral infections (Hepatitis A, B, C, D, E), but also by alcohol, drugs, or autoimmune conditions.",
            symptoms = listOf("Jaundice (yellowing of skin and eyes)", "Dark urine", "Pale or clay-colored stools", "Fatigue", "Nausea and vomiting", "Abdominal pain (especially upper right)", "Loss of appetite", "Fever", "Joint pain", "Itchy skin"),
            causes = listOf("Viral infection (Hepatitis A, B, C, D, E)", "Alcohol abuse (Alcoholic hepatitis)", "Autoimmune disorders (Autoimmune hepatitis)", "Medications and toxins", "Fatty liver disease (NAFLD/NASH)", "Blood transfusion (before screening)", "Sharing needles", "Unsafe sexual practices", "Mother-to-child transmission (Hep B, C)", "Contaminated food/water (Hep A, E)"),
            prevention = listOf("Get vaccinated (Hepatitis A and B)", "Practice safe sex", "Don't share needles or personal items like razors", "Ensure safe blood transfusions", "Practice good hand hygiene", "Avoid contaminated food and water when traveling", "Limit alcohol consumption", "Use medications as directed", "Get tested if at risk"),
            safetyPractices = listOf("Avoid alcohol completely if you have hepatitis", "Don't donate blood if infected", "Cover cuts and wounds", "Inform sexual partners if you have Hepatitis B or C", "Use barrier protection during sex", "Follow up regularly with liver function tests", "Report signs of worsening liver disease (confusion, bleeding, swelling)"),
            foodGuidance = "Eat a liver-friendly diet: plenty of fruits, vegetables, whole grains, and lean protein. Avoid alcohol completely. Limit salt, sugar, and saturated fats. Eat small, frequent meals if nauseated. Avoid raw shellfish. Stay hydrated with water.",
            medicines = listOf("Antiviral medications (Entecavir, Tenofovir for Hep B; Sofosbuvir, Ledipasvir for Hep C)", "Interferon (for Hepatitis B and C)", "Corticosteroids (for autoimmune hepatitis)", "Antirejection medications", "Silymarin (milk thistle - supportive)", "Vaccines (Hepatitis A, B prevention)"),
            medicineGuide = "Hepatitis treatment varies by type. Hepatitis C is now curable with direct-acting antivirals. Hepatitis B requires long-term management. Take all medications exactly as prescribed. Avoid alcohol and limit acetaminophen use. Regular monitoring of liver function is essential.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Hepatitis A", description = "Acute viral hepatitis spread through contaminated food/water. Usually resolves on its own. Preventable by vaccine."),
                DiseaseType(name = "Hepatitis B", description = "Viral hepatitis spread through blood and body fluids. Can be acute or chronic. Preventable by vaccine."),
                DiseaseType(name = "Hepatitis C", description = "Blood-borne viral hepatitis. Often becomes chronic. Now curable with modern antiviral treatment."),
                DiseaseType(name = "Alcoholic Hepatitis", description = "Liver inflammation caused by heavy alcohol use. Requires immediate alcohol cessation.")
            )
        ),
        Disease(
            id = "asthma_en",
            name = "Asthma",
            category = "Respiratory",
            definition = "Asthma is a chronic condition where airways narrow, swell, and produce extra mucus, making breathing difficult.",
            symptoms = listOf("Shortness of breath", "Wheezing (whistling sound when breathing out)", "Chest tightness or pain", "Coughing (especially at night or early morning)", "Trouble sleeping due to breathing problems", "Fatigue", "Rapid breathing", "Anxiety or panic during attacks"),
            causes = listOf("Genetic factors (family history)", "Allergens (dust mites, pollen, pet dander, mold)", "Respiratory infections", "Physical activity (exercise-induced asthma)", "Cold air", "Air pollution and smoke", "Certain medications (aspirin, beta blockers)", "Stress and strong emotions", "Sulfites in food", "Occupational exposures (chemicals, dust)"),
            prevention = listOf("Identify and avoid triggers", "Take controller medications as prescribed", "Get vaccinated for flu and pneumonia", "Monitor breathing with a peak flow meter", "Maintain a healthy weight", "Manage allergies", "Avoid smoke and air pollution", "Warm up before exercise", "Create an asthma action plan with your doctor"),
            safetyPractices = listOf("Always carry your rescue inhaler", "Know the signs of an asthma attack", "Seek emergency care if rescue inhaler doesn't help", "Avoid known triggers", "Use a spacer with inhalers if recommended", "Keep your home free of dust and mold", "Wash bedding frequently in hot water", "Don't smoke and avoid secondhand smoke"),
            foodGuidance = "Maintain a healthy diet rich in fruits, vegetables, and omega-3 fatty acids (fish, walnuts) which may help reduce inflammation. Some people with asthma may be sensitive to sulfites (found in wine, dried fruit, pickled foods) - avoid if they trigger symptoms. Maintain a healthy weight, as obesity can worsen asthma. Stay hydrated.",
            medicines = listOf("Quick-relief (rescue) inhalers: Albuterol, Levalbuterol", "Long-term control medications: Inhaled corticosteroids (Fluticasone, Budesonide)", "Leukotriene modifiers (Montelukast)", "Long-acting beta agonists (LABA)", "Combination inhalers", "Biologics (for severe asthma: Omalizumab, Mepolizumab)", "Theophylline"),
            medicineGuide = "Use controller medications daily even when feeling well - they prevent attacks. Rescue inhalers are for immediate relief during symptoms. If you use your rescue inhaler more than twice a week, your asthma may not be well controlled - see your doctor. Learn proper inhaler technique.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Allergic Asthma", description = "The most common type, triggered by allergens like pollen, dust mites, pet dander, or mold."),
                DiseaseType(name = "Non-Allergic Asthma", description = "Triggered by factors other than allergies: stress, exercise, cold air, infections, or irritants."),
                DiseaseType(name = "Exercise-Induced Asthma (EIB)", description = "Symptoms triggered by physical activity, usually starting during or shortly after exercise."),
                DiseaseType(name = "Occupational Asthma", description = "Caused by exposure to substances at work, such as chemicals, dust, or fumes.")
            )
        ),
        Disease(
            id = "stroke_en",
            name = "Stroke",
            category = "Nervous",
            definition = "A stroke occurs when blood flow to part of the brain is interrupted or reduced, preventing brain tissue from getting oxygen and nutrients.",
            symptoms = listOf("Sudden numbness or weakness in face, arm, or leg (especially on one side)", "Sudden confusion or trouble speaking", "Sudden trouble seeing in one or both eyes", "Sudden trouble walking, dizziness, or loss of balance", "Sudden severe headache with no known cause", "Sudden trouble understanding speech", "Sudden severe dizziness", "Drooping of one side of the face", "Loss of coordination"),
            causes = listOf("High blood pressure (leading cause)", "High cholesterol", "Smoking", "Diabetes", "Atrial fibrillation (irregular heartbeat)", "Carotid artery disease", "Obesity", "Physical inactivity", "Excessive alcohol use", "Drug abuse (cocaine, amphetamines)", "Family history", "Age", "Prior stroke or TIA"),
            prevention = listOf("Control high blood pressure", "Quit smoking", "Manage diabetes", "Treat atrial fibrillation", "Lower cholesterol", "Maintain healthy weight", "Exercise regularly", "Eat a healthy diet (low salt, low fat)", "Limit alcohol", "Take prescribed medications (blood thinners, antiplatelets)", "Recognize and treat TIAs (mini-strokes) immediately"),
            safetyPractices = listOf("CALL EMERGENCY SERVICES IMMEDIATELY - time is brain!", "Use the FAST test: Face drooping, Arm weakness, Speech difficulty, Time to call", "Note when symptoms started - this affects treatment options", "Do not give the person anything to eat or drink", "Do not give aspirin unless directed by medical professionals", "Keep the person calm and comfortable", "Be prepared for rehabilitation after a stroke", "Attend all follow-up appointments"),
            foodGuidance = "Follow a DASH or Mediterranean diet: low in salt (limit to under 1,500 mg/day if hypertensive), saturated fat, and cholesterol. Eat plenty of fruits, vegetables, whole grains, and lean proteins. Include omega-3 rich foods. Limit alcohol. If swallowing difficulties exist (dysphagia) after stroke, follow speech therapist's dietary recommendations.",
            medicines = listOf("Antiplatelets (Aspirin, Clopidogrel)", "Anticoagulants (Warfarin, Apixaban, Rivaroxaban)", "Antihypertensives (for blood pressure control)", "Statins (for cholesterol)", "tPA (tissue plasminogen activator - emergency clot-busting drug)", "Antidiabetic medications", "Anti-seizure medications (post-stroke)"),
            medicineGuide = "Stroke prevention medications must be taken exactly as prescribed. Antiplatelets and anticoagulants increase bleeding risk - report any unusual bruising or bleeding. Blood pressure and cholesterol medications are crucial for preventing another stroke. Never stop these medications without consulting your doctor.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Ischemic Stroke", description = "Most common type (87%). Caused by a blockage or clot in a blood vessel supplying the brain."),
                DiseaseType(name = "Hemorrhagic Stroke", description = "Caused by a blood vessel in the brain leaking or rupturing. Often due to high blood pressure or aneurysms."),
                DiseaseType(name = "Transient Ischemic Attack (TIA)", description = "A 'mini-stroke' with temporary symptoms. A warning sign that a major stroke may occur. Requires immediate medical attention."),
                DiseaseType(name = "Cryptogenic Stroke", description = "A stroke with no clear cause found after standard testing.")
            )
        )
    )

    // --- Extra hypertension entry for new diseases test ---
    val diseasesEnExtra = listOf(
        Disease(
            id = "hypertension_en",
            name = "Hypertension (High Blood Pressure)",
            category = "Heart",
            definition = "Hypertension is a condition where the force of blood against artery walls is consistently too high, increasing the risk of heart disease and stroke.",
            symptoms = listOf("Often asymptomatic", "Severe headaches", "Shortness of breath", "Nosebleeds", "Fatigue or confusion", "Chest pain", "Irregular heartbeat", "Vision changes"),
            causes = listOf("High salt intake", "Obesity", "Lack of exercise", "Smoking", "Genetics", "Chronic stress", "Excessive alcohol", "Age"),
            prevention = listOf("Reduce salt intake", "Regular exercise (30 min daily)", "Maintain healthy weight", "Quit smoking", "Manage stress", "Limit alcohol", "Eat potassium-rich foods"),
            safetyPractices = listOf("Monitor blood pressure daily", "Take medication exactly as prescribed", "Avoid heavy lifting if symptomatic", "Reduce stress through relaxation techniques", "Maintain a low-sodium diet"),
            foodGuidance = "Eat potassium-rich foods (bananas, beans, spinach). Avoid processed snacks and high-sodium foods. Use herbs and spices instead of salt for flavoring. Limit alcohol consumption. Choose fresh fruits and vegetables over canned or processed options.",
            medicines = listOf("Amlodipine", "Lisinopril", "Hydrochlorothiazide", "Losartan", "Metoprolol"),
            medicineGuide = "Take daily at the same time. Never skip doses without consulting your doctor. Monitor blood pressure regularly. Do not stop medication abruptly even if you feel fine.",
            language = "en",
            types = listOf(
                DiseaseType(name = "Primary (Essential) Hypertension", description = "The most common type with no identifiable cause. Develops gradually over many years."),
                DiseaseType(name = "Secondary Hypertension", description = "Caused by an underlying condition such as kidney disease, thyroid problems, or certain medications."),
                DiseaseType(name = "Malignant Hypertension", description = "A severe form with very high blood pressure that can damage organs rapidly. Requires emergency treatment.")
            )
        )
    )

    val diseasesOm = listOf(
        Disease(
            id = "heart_hypertension_om",
            name = "Dhiibbaa Dhiigaa (Hypertension)",
            category = "Heart",
            definition = "Dhiibbaa dhiigaa jechuun humna dhiigni ujummoolee dhiigaa keessatti dhiibu cimaa ta'uu dha.",
            symptoms = listOf("Mataa dhukkubbi", "Hafuura cituu", "Mataa naannessuu"),
            causes = listOf("Soogidda baay'isuu", "Ulaanaa", "Tamboo"),
            prevention = listOf("Soogidda hir'isuu", "Sochii qaamaa"),
            safetyPractices = listOf("Dhiibbaa dhiigaa hordofuu", "Qoricha sirriitti fudhachuu"),
            foodGuidance = "Muusaa fi fuduraa nyaadhaa.",
            medicines = listOf("Amlodipine", "Lisinopril"),
            medicineGuide = "Qoricha guyyaa hunda sa'aatii tokkotti fudhadhaa.",
            language = "om"
        ),
        Disease(
            id = "skin_eczema_om",
            name = "Ekzeemaa (Skin Disease)",
            category = "Skin",
            definition = "Eczema dhibee gogaa gogsuu fi sosochoosu dha.",
            symptoms = listOf("Gogaan goguu", "Hooruu cimaa", "Gogaan diimachuu"),
            causes = listOf("Aangoo (Allergy)", "Kimikaalii"),
            prevention = listOf("Gogaa jiisuu", "Sabuuna madaalawaa"),
            safetyPractices = listOf("Madaa hooruu dhiisuu"),
            foodGuidance = "Bishaan baay'ee dhugaa.",
            medicines = listOf("Hydrocortisone cream"),
            medicineGuide = "Kiriimii gogaa qulqulluu irratti dibadhaa.",
            language = "om"
        ),
        Disease(
            id = "gastritis_om",
            name = "Gastritis",
            category = "Digestive",
            definition = "Gastritis dhibee gogaa dhiigaa (stomach) hubachuuf qophaayuu, cimaa baay'ee, daawwadee, ykn alcohol baay'ee qiboo danda'u.",
            symptoms = listOf("Gogaa dhiigaa guddaa ykn rummuu", "Nausea fi vomitin", "Gogaa dhiigaa danda'u haala bu'uraa", "Bloating", "Indigestion"),
            causes = listOf("H. pylori (Helicobacter pylori) cimaa", "Daawwadee (NSAIDs) badan qabu", "Alcohol baay'ise", "Stress", "Bile reflux", "Autoimmune disorders"),
            prevention = listOf("H. pylori cimaa ta'uu ykn sabuuna morattii fudhachuu", "Daawwadee baay'ee danda'u ykn sirriitti qabu", "Alcohol hir'isuu", "Gogaa dhiigaa danda'ina danda'ina sirriitti fudhachuu", "Stress hir'isu"),
            safetyPractices = listOf("NSAIDs yoo gadi gastritis hubachiif irratti hir'isu", "Taabbaa hir'isuu", "Alcohol hir'isuu", "Gogaa dhiigaa gudda ykn sirriitti ifa yoo ta'e hir'isu", "H. pylori ta'een daawwadee fudhachuu"),
            foodGuidance = "Gogaa dhiigaa sirriitti hunde danda'ina danda'ina sirriitti fudhachuu. Taabbaa, meen, fi fried foods fi caffeine hinkanisu. Oatmeal, banana, fi yogurt kina danda'u. Bashannaaf boodhammatti booda fudhachuu.",
            medicines = listOf("Antacids (Maalox, Tums)", "H2 blockers (Famotidine)", "PPIs (Omeprazole, Pantoprazole)", "Antibiotics (H. pylori ta'een)"),
            medicineGuide = "Acids harmachuu daawwadee hundaa'aa sirriitti, gogaa boodhammatti. H. pylori fudhachuu, antibiotics kana ta'een guutuu fudhachuu. NSAIDs ykn taabbaa irraa daawwadee irraa hir'isu.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Erosive Gastritis", description = "Gogaa dhiigaa hubachuuf qophaayuu, erosions ykn ulcers produce."),
                DiseaseType(name = "Non-Erosive Gastritis", description = "Erosions ykn ulcers hubachiif, gogaa dhiigaa hubachuuf qophaayuu hin danda'u.")
            )
        ),
        Disease(
            id = "peptic_ulcer_om",
            name = "Peptic Ulcer Disease",
            category = "Digestive",
            definition = "Peptic ulcer disease dhinee gogaa dhiigaa (gastric ulcer) fi small intestine gudatti walitti (duodenal ulcer) hubachuuf qophaayuu, dhie gogaa hubachiif qophaayuu.",
            symptoms = listOf("Gogaa dhiigaa guddaa ykn rummuu", "Danda'u fi bloating, burping", "Fatty food intolerant", "Heartburn", "Nausea", "Dark fi tarlik stools", "Vomiting blood"),
            causes = listOf("H. pylori cimaa", "NSAIDs badan qabu", "Alcohol baay'ise", "Stress", "Smoking"),
            prevention = listOf("H. pylori cimaa ta'uu ykn sabuuna morattii fudhachuu", "Daawwadee baay'ee danda'u ykn sirriitti qabu", "Alcohol hir'isu", "Taabbaa hir'isu", "Stress hir'isu"),
            safetyPractices = listOf("If sharp, severe abdominal pain yoo ta'e hir'isu", "Vomiting blood fi coffee grounds look yoo ta'e hir'isu", "Black ykn bloody stools yoo ta'e hir'isu", "Healing during NSAIDs hir'isu"),
            foodGuidance = "Acid neutralisehuuf, balanced meals danda'ina sirriitti fudhachuu. Taabbaa, meen, acidic foods, caffeine, alcohol hinkanisu. Fiber-rich foods fi probiotics (yogurt, kefir) danda'u.",
            medicines = listOf("PPIs (Omeprazole, Esomeprazole)", "H2 blockers (Famotidine)", "Antacids", "Antibiotics (H. pylori)"),
            medicineGuide = "PPIs fi H2 blockers danda'ina hunde sirriitti fudhachuu. H. pylori fudhachuu, antibiotics guutuu fudhachuu. Healing during NSAIDs ykn taabbaa hir'isu.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Gastric Ulcer", description = "Gogaa dhiigaa hubachiif gogaa (stomach) jiraachuu."),
                DiseaseType(name = "Duodenal Ulcer", description = "Small intestine guddaati walitti (duodenum) jiraachuu.")
            )
        ),
        Disease(
            id = "gerd_om",
            name = "GERD (Acid Reflux)",
            category = "Digestive",
            definition = "GERD dhiige gogaa dhiigaa (esophagus) hunde ta'uu, mouth fi stomach ka'uu sababbaaf dhiibu cimaa qorichuu, chronic condition hunde danda'u.",
            symptoms = listOf("Heartburn (chest guddaa rummuu)", "Food fi sour liquid regurgitation", "Swallowing difficulty", "Chest pain", "Dry cough", "Hoarseness fi sore throat", "Throat lump sensation", "Nighttime food fi sour liquid regurgitation"),
            causes = listOf("Lower esophageal sphincter weak", "Hiatal hernia", "Obesity", "Pregnancy", "Smoking", "Certain medications", "Large meals fi lying down after eating"),
            prevention = listOf("Gogaa dhiigaa danda'ina danda'ina sirriitti fudhachuu", "Boomma fudhachuu after eating hin taane", "Healthy weight maintain", "Trigger foods avoid (spicy, fatty, acidic)", "Taabbaa hir'isu", "Bed head elevate"),
            safetyPractices = listOf("Severe chest pain yoo ta'e hir'isu", "Swallowing difficulty ykn painful swallowing yoo ta'e hir'isu", "Unexplained weight loss yoo ta'e hir'isu", "Vomiting blood fi black stools yoo ta'e hir'isu", "Bedtime 2-3 hours fudhachuu boodhammatti fudhachuu"),
            foodGuidance = "Spicy, fatty, acidic foods, chocolate, caffeine, mint trigger foods avoid. Danda'ina meals fi late eating 2-3 hours boodhammatti. Healthy weight. Lean proteins, vegetables, whole grains danda'u.",
            medicines = listOf("Antacids (Aluminum hydroxide, Magnesium hydroxide)", "H2 blockers (Famotidine, Cimetidine)", "PPIs (Omeprazole, Lansoprazole)", "Foaming agents (Gaviscon)"),
            medicineGuide = "PPIs 30-60 min danda'ina fudhachuu. Antacids boomma relief boodhammetti. Long-term use doctor review, older adults baay'ee.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Non-Erosive Reflux Disease (NERD)", description = "Esophagus damage hubachiif heartburn symptoms."),
                DiseaseType(name = "Erosive Esophagitis", description = "Stomach acid daawwadee esophagitis ykn damage.")
            )
        ),
        Disease(
            id = "ibs_om",
            name = "Irritable Bowel Syndrome (IBS)",
            category = "Digestive",
            definition = "IBS large intestine fudhachuu danda'u, cramping, abdominal pain, bloating, gas, diarrhea fi constipation ykn baay'een danda'u.",
            symptoms = listOf("Abdominal pain fi cramping", "Bloating fi gas", "Diarrhea, constipation, ykn baay'een danda'u", "Stool mucus", "Incomplete evacuation feeling", "Stress fi meals related bowel habit changes"),
            causes = listOf("Gut bacteria changes", "Intestinal inflammation", "Severe infection (gastroenteritis)", "Nervous system abnormalities", "Food triggers", "Stress"),
            prevention = listOf("Trigger foods identify fi avoid", "Stress hir'isu", "Balanced meals danda'ina fudhachuu", "Enough fiber", "Physically active", "Food fi symptom diary hojeessa"),
            safetyPractices = listOf("Unexplained weight loss yoo ta'e hir'isu", "Stool blood yoo ta'e hir'isu", "Persistent vomiting yoo ta'e hir'isu", "Nighttime wake symptoms yoo ta'e hir'isu", "Treatment despite symptoms worsen yoo hir'isu"),
            foodGuidance = "Low-FODMAP diet trigger foods identify. Danda'ina meals fi qabataa portions. Soluble fiber (oats, banana, carrots) increase. Hydrated. Gas-producing foods (beans, cabbage) fi artificial sweeteners limit.",
            medicines = listOf("Antispasmodics (cramping)", "Laxatives (constipation)", "Anti-diarrheal (Loperamide)", "Tricyclic antidepressants (low dose, pain)", "Rifaximin (bloating)"),
            medicineGuide = "Symptom treatment baay'ee: laxatives fi anti-diarrheals bowel habit changes. Antispasmodics meals boodhammatti. Pain antidepressants low-dose doctor darressa.",
            language = "om",
            types = listOf(
                DiseaseType(name = "IBS with Constipation (IBS-C)", description = "Constipation predominant symptom."),
                DiseaseType(name = "IBS with Diarrhea (IBS-D)", description = "Diarrhea predominant symptom."),
                DiseaseType(name = "Mixed IBS (IBS-M)", description = "Constipation ykn diarrhea danda'ina.")
            )
        ),
        Disease(
            id = "arthritis_om",
            name = "Arthritis",
            category = "Musculoskeletal",
            definition = "Arthritis joints tokko ykn baay'ee hubachuuf qophaayuu, pain, swelling, fi stiffness fidu.",
            symptoms = listOf("Joint pain", "Stiffness (morning)", "Joint swelling", "Joint redness fi warmth", "Range of motion decrease", "Fatigue", "Flexibility loss"),
            causes = listOf("Osteoarthritis", "Rheumatoid arthritis", "Gout", "Infections", "Dhukkuba aanaa", "Age", "Obesity", "Joint injury duraa", "Smoking"),
            prevention = listOf("Healthy weight maintain", "Low-impact exercise", "Joints injury irraa eeguu", "Muscles around joints cimsuu", "Anti-inflammatory diet", "Smoking dhiisuu", "Repetitive joint stress hir'isuu"),
            safetyPractices = listOf("Stiffness cold, swelling heat fayyadami", "Yoo barbaachise assistive devices fayyadami", "Inactivity dheeraa irraa of eeguu", "Medicines prescribed sirriitti fudhachuu", "Severe swelling ykn fever doctor himi"),
            foodGuidance = "Anti-inflammatory diet nyaadhaa: omega-3 (muusaa, walnuts, flaxseed), fruits, vegetables, fi whole grains. Foon diimaa, sugar, alcohol, fi processed foods hir'isuu. Healthy weight maintain joints load hir'isuuf.",
            medicines = listOf("Pain relievers (Acetaminophen)", "NSAIDs (Ibuprofen, Naproxen)", "DMARDs (Methotrexate)", "Corticosteroids", "Biologics", "Gout medicines (Allopurinol, Colchicine)"),
            medicineGuide = "Pain fi anti-inflammatory medicines prescribed sirriitti fudhadhaa. NSAIDs dose hinduu hin dabarsine. DMARDs blood monitoring barbaachisu.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Osteoarthritis", description = "Common type, joint cartilage wear-and-tear cause."),
                DiseaseType(name = "Rheumatoid Arthritis", description = "Autoimmune disorder immune system joints attack."),
                DiseaseType(name = "Gout", description = "Uric acid crystals cause severe attacks, big toe baay'ee."),
                DiseaseType(name = "Infectious Arthritis", description = "Bacteria ykn viruses cause joint infection, urgent treatment barbaachisa.")
            )
        ),
        Disease(
            id = "back_pain_om",
            name = "Back Pain (Lower Back Pain)",
            category = "Musculoskeletal",
            definition = "Back pain namoota hojii dhabsiisu fi disability fidu, strain, posture hinkanisuu, ykn spinal conditions irraa dhufa.",
            symptoms = listOf("Back keessatti dull aching pain", "Stiffness ykn tightness", "Sharp pain", "Leg down radiate pain (sciatica)", "Range of motion xiqqaachuu", "Muscle spasms", "Bending ykn lifting pain worsens"),
            causes = listOf("Muscle ykn ligament strain", "Heavy lifting", "Posture hinkanisuu ykn sitting dheeraa", "Disc herniated", "Scoliosis", "Osteoporosis", "Spine arthritis", "Obesity", "Exercise dhabuu", "Stress"),
            prevention = listOf("Posture gaarii", "Exercise fi stretch regularly", "Core muscles cimsuu", "Proper lifting technique (knee bend)", "Healthy weight", "Sitting dheeraa irraa of eeguu", "Supportive chair fi mattress", "Smoking dhiisuu"),
            safetyPractices = listOf("Bladder/bowel control dhabuu ykn groin numbness yoo ta'e urgent care", "Legs lame weakness himi", "Fall ykn accident booda back pain himi", "Bed rest dheeraa irraa of eeguu", "Heat ykn cold fayyadami"),
            foodGuidance = "Calcium fi vitamin D (dairy, leafy greens, fortified foods) bone health. Anti-inflammatory foods (muusaa, nuts, vegetables). Hydrated fi healthy weight.",
            medicines = listOf("Pain relievers (Acetaminophen)", "NSAIDs (Ibuprofen, Naproxen)", "Muscle relaxants", "Topical pain relievers", "Antidepressants (nerve pain)", "Corticosteroid injections"),
            medicineGuide = "Pain medicines yeroo gabaabaaf directed fudhadhaa. NSAIDs older adults fi kidney/stomach problems qabaniif of eeggannoo. Chronic pain multidisciplinary plan barbaachisa.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Acute Back Pain", description = "Torban 6 gadi sudden pain, muscle strain irraa, of irraa fooyya'a."),
                DiseaseType(name = "Chronic Back Pain", description = "Torban 12 ol pain, disc ykn joint problems irraa."),
                DiseaseType(name = "Sciatica", description = "Sciatic nerve along pain, lower back irraa leg tokko dhaan."),
                DiseaseType(name = "Herniated Disc", description = "Disc bulge ykn rupture, nerves dhiibuu.")
            )
        ),
        Disease(
            id = "osteoporosis_om",
            name = "Osteoporosis",
            category = "Musculoskeletal",
            definition = "Osteoporosis lafee laafaa godha, salphaatti caccaban, baay'ee yeroo symptoms hin qabu fracture ta'uu irratti.",
            symptoms = listOf("Early stages symptoms hin qabu", "Vertebra fractured back pain", "Height dheeraa qaama hir'achuu", "Stooped posture", "Minor falls irraa fractures", "Receding gums", "Weak grip strength"),
            causes = listOf("Age fi hormonal changes (menopause booda)", "Calcium intake xiqqaa", "Vitamin D deficiency", "Physical activity dhabuu", "Smoking", "Alcohol baay'ee", "Corticosteroid use dheeraa", "Family history", "Body weight xiqqaa"),
            prevention = listOf("Calcium fi vitamin D enough argachuu", "Weight-bearing fi muscle-strengthening exercise", "Smoking dhiisuu", "Alcohol limit", "Mana keessatti falls prevent", "Healthy body weight", "Risk yoo jiraate bone density check"),
            safetyPractices = listOf("Falls prevent (rugs kutu, lighting fooyyessi)", "Posture fi body mechanics gaarii", "Supplements recommended fudhachuu", "Bone density checks regularly", "Sudden severe back pain doctor himi"),
            foodGuidance = "Calcium-rich foods (milk, yogurt, cheese, leafy greens, sardines) fi vitamin D sources (muusaa, egg yolks, fortified foods). Caffeine, salt, fi alcohol limit. Protein enough.",
            medicines = listOf("Calcium fi vitamin D supplements", "Bisphosphonates (Alendronate, Risedronate)", "Calcitonin", "Denosumab", "Hormone therapy", "Teriparatide"),
            medicineGuide = "Calcium fi vitamin D advised fudhadhaa, nyaata waliin. Bisphosphonates stalee empty stomach irratti bishaan waliin fudhachuu fi daqiiqaa 30 dhaabbachuu. Bone density monitoring.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Primary Osteoporosis", description = "Aging fi hormonal changes irraa, common form, menopause booda baay'ee."),
                DiseaseType(name = "Secondary Osteoporosis", description = "Condition other ykn medication (steroid dheeraa) irraa."),
                DiseaseType(name = "Osteopenia", description = "Bone density normal gadi ta'uu, osteoporosis hin ta'e. Warning stage.")
            )
        ),
        Disease(
            id = "blood_anemia_om",
            name = "Hanqina Dhiigaa (Anemia)",
            category = "Blood",
            definition = "Anemia dhibee unkoollinni dhiigaa diimaan hir'achuu dha.",
            symptoms = listOf("Dadhabbi guddaa", "Ifa fuulaa", "Hafuura dhabuu"),
            causes = listOf("Hanqina ayiraanii", "Dhiigni baay'ee yaa'uu"),
            prevention = listOf("Nyaata ayiraanii qabu"),
            safetyPractices = listOf("Boqochuu", "Suuta ka'uu"),
            foodGuidance = "Foon diimaa fi kukkuluu (beans) nyaadhaa.",
            medicines = listOf("Iron supplements"),
            medicineGuide = "Dawaa ayiraanii nyaata waliin fudhachuun gaariidha.",
            language = "om"
        ),
        Disease(
            id = "malaria_om",
            name = "Busaa (Malaria)",
            category = "Infectious",
            definition = "Dhibee paraasaitii bilaasmoojiyeemiin dhufu, yeroo bookeen dhaltuu nama hinfu.",
            symptoms = listOf("Ho'a qamaa", "Qorra", "Mataa dhukkubbi", "Miidiya dhukkubbi", "Hafuura dhiibbaa"),
            causes = listOf("Paraasaitii bilaasmoojiyeemii (Plasmodium)", "Hiddannoo bookee (Anopheles mosquito)"),
            prevention = listOf("Agoobaratti fayyadamuu (bed net)", "Qoricha bookee ari'utti fayyadamuu", "Bishaan hin taane tuqee fudhadhaa qorichuu"),
            safetyPractices = listOf("Yoo ho'i qamaa itti fufe gara mana yaalaa deemuu", "Qoricha guutuu fudhachuu", "Bookeen dhukkuba yoo ta'e yaalattan qoricha maqaa fuula"),
            foodGuidance = "Nyaata madaalawaa soorachuu: fuduraa, muduraa, killee. Bishaan baay'ee dhugaa nyaadhaa.",
            medicines = listOf("Artemether-lumefantrine (Coartem)", "Chloroquine"),
            medicineGuide = "Qorichaa ta'een guutuu fudhachuu, hundaa'aa sirriitti ta'een ifa dhuunfaa fi karaa hopanna baayyisa.",
            language = "om"
        ),
        Disease(
            id = "cancer_om",
            name = "Kansaaraa (Cancer)",
            category = "Chronic",
            definition = "Kansaaraa dhiibee hubachuuf guddoo qophaayuu dha, nama keessatti hundaan waraabsuu danda'u.",
            symptoms = listOf("Dadhabbi guddaa", "Mukka dhuunfaa", "Hafuura dhabuu", "Baay'ina bu'uuraa", "Mukka lama qabaachuu", "Mataa dhukkubbi", "Dhiigan isaa hirriba", "Gogaa yaadachuuf qophii"),
            causes = listOf("Taabbaa (smoking)", "Alcohol baay'ise", "Nyaata hinkanisuu", "Aktiiifitiivii hin qabu", "Ulaanaa", "Ibiddoo madda ninna (sun)", "Cimaa baay'ee", "Dhukkuba aanaa"),
            prevention = listOf("Taabbaa hir'isuu", "Alcohol hir'isuu", "Nyaata madaalawaa", "Sochii qaamaa garuu baay'ee", "Bishaan dhugaa nyaadhaa", "Gogaa jiisuu", "Cimaa hordoffaa guutummaa taasisu", "Dhukkuba cimaa baay'ee hordofaa"),
            safetyPractices = listOf("Dhukkuba namoota taasifama sirriitti ilaalluu", "Cimaa hordoffaa guutummaa taasisu", "Dhukkuba aanaa yoo ta'e yaalattan harkaba harkisu", "Bishaan dhugaa fi kalleessa nyaadhaa", "Dhukkub baay'ee baayyisa"),
            foodGuidance = "Nyaata madaalawaa soorachuu: fuduraa, killee, muduraa, nimoo, carrot. Buzzoo nyaata hin barbaachisu. Bishaan baay'ee dhugaa dhugaa nyaadhaa. Muusaa fi fuduraa nyaadhaa.",
            medicines = listOf("Chemotherapy", "Immunotherapy", "Targeted therapy", "Hormone therapy", "Radiation therapy"),
            medicineGuide = "Daawwadee oncologist sirriitti fudhadhaa. Dhukkuba hundaa'aa sirriitti ilaalluu. Barbaaduun barbaaduun daawwadee fudhachuu danda'u.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Carcinomas", description = "Kansaaraa gogaa udura tokkoon hubattee itti fufe guddoo qophaayuu dha."),
                DiseaseType(name = "Sarcomas", description = "Kansaaraa kalleessa, carteegii, fat, muscle ykn blood vessels keessatti jiraachuu dha."),
                DiseaseType(name = "Leukemias", description = "Kansaaraa blood-forming tissues keessatti, archeruu madre kalaqaa keenya keessatti jiraachuu dha."),
                DiseaseType(name = "Lymphomas", description = "Kansaaraa lymphatic system keessatti, cimaa hubachuun harkbaa keenya keessatti jiraachuu dha.")
            )
        ),
        Disease(
            id = "heart_disease_om",
            name = "Dhiibbaa Dhiigaa (Heart Disease)",
            category = "Heart",
            definition = "Dhiibbaa dhiigaa dhiibee dhiigaa qubachu, dhiigaa hin taane, ykn dhiigaa hubachuuf qophaayuu dha.",
            symptoms = listOf("Mataa dhukkubbi", "Dhiigan deeman qabu", "Hafuura dhabuu", "Godee baay'ee", "Dhiigan isa hirriba", "Dhiigan mana yaala salaamaa hin taane"),
            causes = listOf("Dhiigaa hubachuussa (plaque)", "Cholesterool baay'ee", "Dhiibbaa dhiigaa", "Taabbaa", "Diabetes", "Ulaanaa", "Nyaata hinkanisuu", "Aktiiifitiivii hin qabu", "Alcohol baay'ise", "Dhukkuba aanaa", "Aberaa", "Stress"),
            prevention = listOf("Dhiigaa hubachuu", "Aktiiifitiivii sochisu", "Ulaanaa hir'isu", "Taabbaa hir'isuu", "Alcohol hir'isuu", "Stress hir'isuu", "Dhiibbaa dhiigaa fi cholesterool hordoffa", "Diabetes hordoffa", "Dhukkuba cimaa guutummaa taasisu"),
            safetyPractices = listOf("Dhiibbaa dhiigaa dhukkuba cimaa sirriitti ilaalluu", "Call 991 ykn 911 yoo dhukkuba ta'e", "Daawwadee hundaa'aa sirriitti fudhadhaa", "Cardiac rehabilitation hubachuun qophii", "Walkii baay'ee hordoffaa", "Cardiologist hubachuun baayyisa"),
            foodGuidance = "Mediterranean diet nyaadhaa: muusaa (salmon, tuna), olive oil, nuts, whole grains, fruits, fi vegetables. Faturaa hinkanisuu, trans fat, cholesterool, sodium fi added sugar hinkanisu. Portion saiz hordoffa. Sodium hir'isu dhiibbaa dhiigaa hordoffa.",
            medicines = listOf("Aspirin", "Beta blockers", "Statins", "ACE inhibitors", "Calcium channel blockers", "Diuretics", "Nitroglycerin"),
            medicineGuide = "Dhiigaa daawwadee hundaa'aa sirriitti fudhadhaa. Daawwadee hir'isuun waliin ta'e dhugaa godhe. Baayyisa baayyisa godhe. Side effects yaadda differences barbaada.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Coronary Artery Disease", description = "Dhiigaa hubachuussa (plaque baddaa) arteria coronary jalqaba ta'uu dha."),
                DiseaseType(name = "Arrhythmia", description = "Dhiigaa rhythms hubachuuf qubachuuf, dhiigaa dhee Adhuu, dhee tokko, ykn irregular jiraachuu dha."),
                DiseaseType(name = "Heart Failure", description = "Dhiigaa hundee baay'ee dhiigaa hubachuuf qophaayuu danda'u dha."),
                DiseaseType(name = "Valvular Heart Disease", description = "Dhiigaa valves hubachu, defect jiraachuu dha.")
            )
        ),
        Disease(
            id = "brain_disease_om",
            name = "Digaa Digaa (Brain Disease)",
            category = "Nervous",
            definition = "Digaa diga dhiigee digaa qubachu, epilepsy, Alzheimer's disease, Parkinson's disease, ykn diga dhiibee duraa dha.",
            symptoms = listOf("Mataa dhukkubbi guddaa", "Hirmaannoo ykn service hubachuuf qophii", "Seizures", "Walitti qophaayuu hin taane", "Numbness ykn tingling", "Muscle weakness", "Mataa dhukkubbi", "Martoo dhukkubbi", "Mood ykn behavior hubachuuf qophii", "Dizziness", "Loss of consciousness"),
            causes = listOf("Dhukkuba aanaa", "Cimaa (meningitis, encephalitis)", "Traumatic brain injury", "Stroke (dhiigaa hin taane)", "Autoimmune disorders", "Degenerative processes (Alzheimer's, Parkinson's)", "Tumors", "Environmental toxins", "Nyaata hinkanisuu", "Chronic stress", "Sleep disorders"),
            prevention = listOf("Head protect (helmets fayyadamu)", "Dhiibbaa dhiigaa hordoffa", "Nyaata madaalawaa", "Aktiiifitiivii sochisu", "Adequate sleep", "Stress hir'isu", "Mentally aktiiifitiivii jiraatu", "Alcohol ykn drugs baay'ee hir'isu", "Cimaa baayyisa sirriitti fudhachuu", "Diabetes fi cholesterool hordoffa"),
            safetyPractices = listOf("Dhukkuba guddaa sirriitti emergency care fudhachuu", "Seizure disorders daawwadee hundaa'aa sirriitti fudhadhaa", "Falls prevent environment", "Medical ID seizure disorder yoo ta'e", "Condition uncontrolled yoo ta'e driving hin taane", "Neurology appointments baayyisa"),
            foodGuidance = "Brain-healthy diet nyaadhaa: omega-3 fatty acids (muusaa, walnuts, flaxseeds), antioxidants (berries, leafy greens), fi B vitamins. Processed foods, trans fats, fi sugar baay'ee hinkanisu. Bishaan dhugaa dhugaa nyaadhaa. Mediterranean ykn MIND diet cognitive health keessatti yaadda.",
            medicines = listOf("Anticonvulsants (epilepsy)", "Antipsychotics", "Antidepressants", "Cholinesterase inhibitors (Alzheimer's)", "Dopamine agonists (Parkinson's)", "Anticoagulants (stroke prevention)", "Corticosteroids (inflammation)"),
            medicineGuide = "Diga daawwadee hundaa'aa sirriitti fudhadhaa. Seizure ykn psychiatric medications hir'isuun waliin ta'e danda'u. Mood ykn behavior hubachuu side effects ilaalluu. Blood monitoring baayyisa.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Stroke", description = "Dhiigaa digaa keessatti hin taane, brain cells death. Ischemic (blockage) ykn hemorrhagic (bleeding) ta'uu danda'u."),
                DiseaseType(name = "Alzheimer's Disease", description = "Neurodegenerative disease guddaa, memory loss, cognitive decline, fi behavior hubachuuf qophaayuu dha."),
                DiseaseType(name = "Parkinson's Disease", description = "Movement hubachuuf qophaayuu dha, tremors, stiffness, fi balance problems."),
                DiseaseType(name = "Epilepsy", description = "Neurological disorder recurrent, unprovoked seizures jiraachuu dha.")
            )
        ),
        Disease(
            id = "lung_disease_om",
            name = "Manaa Manaa (Lung Disease)",
            category = "Respiratory",
            definition = "Lung dhiibee respiratory system keessatti hubachuuf qophaayuu dha, COPD, asthma, pneumonia, pulmonary fibrosis, fi lung cancer.",
            symptoms = listOf("Hafuura shortness", "Cough persistent", "Wheezing", "Chest pain ykn tightness", "Mucus ykn blood coughing", "Fatigue", "Respiratory infections baay'ee", "Ankles, feet, ykn legs swelling", "Blue tint lips ykn fingernails (cyanosis)", "Rapid, shallow breathing"),
            causes = listOf("Taabbaa (COPD fi lung cancer primary cause)", "Air pollution", "Occupational exposures (dust, chemicals)", "Cimaa (bacterial, viral, fungal)", "Dhukkuba aanaa (alpha-1 antitrypsin deficiency)", "Allergens", "Autoimmune conditions", "Age", "Indoor air quality hinkanisuu", "Secondhand smoke"),
            prevention = listOf("Taabbaa ykn secondhand smoke hir'isuu", "Home radon test", "Air pollution hin qabu yoo ta'e avoid", "Infections prevent hygiene", "Vaccinated (flu, pneumonia)", "Work protective equipment", "Lungs strengthen aktiiifitiivii", "Healthy weight", "Allergies manage"),
            safetyPractices = listOf("Severe shortness breath yoo ta'e immediate care", "Inhalers prescribed sirriitti fudhadhaa", "Asthmatic yoo ta'e rescue inhaler carry", "Triggers (smoke, dust, allergens) avoid", "Flu vaccine annual", "Oxygen levels monitor yoo recommend", "Breathing exercises"),
            foodGuidance = "Balanced diet adequate protein respiratory muscles maintain. Anti-inflammatory foods fatty fish, turmeric, ginger, fi leafy greens. Hydration mucus thin. Gas-producing foods diaphragm press avoid. Breathing difficult yoo eating small, frequent meals.",
            medicines = listOf("Bronchodilators (inhalers)", "Corticosteroids (inhaled ykn oral)", "Antibiotics (bacterial infections)", "Antiviral medications", "Oxygen therapy", "Mucolytics", "Phosphodiesterase-4 inhibitors", "Biologic therapies (severe asthma)"),
            medicineGuide = "Inhalers prescribed sirriitti fudhadhaa - proper technique essential. Steroid inhalers after mouth rinse oral thrush prevent. Rescue inhaler run out hin taane. Worsening symptoms doctor promptly.",
            language = "om",
            types = listOf(
                DiseaseType(name = "COPD (Chronic Obstructive Pulmonary Disease)", description = "Progressive lung disease emphysema fi chronic bronchitis, mainly smoking cause."),
                DiseaseType(name = "Asthma", description = "Airways narrow fi swell, extra mucus, breathing difficult."),
                DiseaseType(name = "Pneumonia", description = "Air sacs one ykn both lungs inflame, fluid ykn pus fill."),
                DiseaseType(name = "Pulmonary Fibrosis", description = "Lung tissue scarring progressive, breathing harder.")
            )
        ),
        Disease(
            id = "tb_om",
            name = "Tuberculosis (TB)",
            category = "Infectious",
            definition = "TB dhiibee lungs hubachuuf qophaayuu, Mycobacterium tuberculosis bacteria cause.",
            symptoms = listOf("Cough persistent (3+ weeks)", "Blood ykn sputum coughing", "Chest pain", "Fatigue", "Ho'a", "Night sweats", "Weight loss unintended", "Appetite loss", "Chills", "Shortness breath"),
            causes = listOf("Mycobacterium tuberculosis bacteria", "Airborne transmission (infected person droplets inhale)", "Immune system weak (HIV, diabetes, chemotherapy)", "Infected person contact close", "High-prevalence areas live ykn travel", "Malnutrition", "Substance abuse", "Healthcare work"),
            prevention = listOf("BCG vaccine (high-risk areas)", "TB treatment complete full course", "Cover mouth cough", "Ventilation good", "Mask infectious yoo ta'e", "Exposed yoo ta'e test", "Latent TB infection treat", "Nutrition fi immune health maintain"),
            safetyPractices = listOf("Antibiotics hundaa'aa sirriitti fudhadhaa", "Cover mouth ykn nose cough ykn sneeze", "Tissues proper dispose", "Rooms well ventilate", "Non-infectious hin taane others contact avoid", "Sputum tests scheduled follow-up", "Medication side effects doctor report"),
            foodGuidance = "Nutrient-rich diet adequate protein (eggs, lean meat, beans, dairy), complex carbohydrates, fi fresh fruits fi vegetables. TB metabolic demand increase, calorie intake higher need. Vitamin D fi zinc immune function support. Treatment during alcohol avoid daawwadee interact.",
            medicines = listOf("Isoniazid (INH)", "Rifampin (RIF)", "Ethambutol", "Pyrazinamide", "Streptomycin (injectable)"),
            medicineGuide = "TB treatment 6-9 months multiple antibiotics take. Prescribed sirriitti fudhachuu. Missed doses drug-resistant TB lead. Directly Observed Therapy (DOT) recommend. Liver function treatment during monitor.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Latent TB Infection", description = "TB bacteria body keessatti present akka inactive. Symptoms hin qabu fi contagious hin taane, active later become danda'u."),
                DiseaseType(name = "Active TB Disease", description = "TB bacteria multiply fi body attack. Symptoms present fi contagious."),
                DiseaseType(name = "Miliary TB", description = "Rare form TB bacteria bloodstream through body spread."),
                DiseaseType(name = "Drug-Resistant TB", description = "TB standard medications respond hin taane, second-line drugs longer treatment.")
            )
        ),
        Disease(
            id = "pneumonia_om",
            name = "Pneumonia",
            category = "Infectious",
            definition = "Pneumonia dhiibee air sacs one ykn both lungs hubachuuf qophaayuu, fluid ykn pus fill.",
            symptoms = listOf("Cough (phlegm produce)", "Ho'a, sweating, fi shaking chills", "Shortness breath", "Rapid, shallow breathing", "Chest pain breathing ykn cough worsen", "Appetite loss", "Fatigue", "Nausea fi vomiting", "Confusion (older adults)", "Blue lips ykn nails (severe cases)"),
            causes = listOf("Bacteria (Streptococcus pneumoniae - common)", "Viruses (influenza, RSV, coronavirus)", "Fungi (immune system weak people)", "Aspiration (food, liquid, ykn vomit inhale)", "Immune system weak", "Respiratory infection recent", "Chronic diseases (COPD, diabetes, heart disease)", "Taabbaa", "Age (very young ykn 65 over)", "Hospitalization (ventilators on)"),
            prevention = listOf("Vaccinated (pneumococcal, flu, COVID-19 vaccines)", "Hands wash frequently", "Taabbaa hin taane", "Immune system healthy maintain", "Chronic conditions manage", "Sick people avoid", "Hygiene good", "Sleep fi nutrition adequate"),
            safetyPractices = listOf("High fever, breathing difficulty, ykn chest pain medical attention", "Prescribed antibiotics hundaa'aa sirriitti fudhadhaa", "Rest fi hydrated", "Humidifier comfort", "Worsening symptoms monitor", "Contagious (viral pneumonia) isolate", "Chest X-ray recommend follow-up"),
            foodGuidance = "Warm, nutritious foods easy digest. Protein-rich foods (chicken soup, eggs, yogurt) healing support. Fluids plenty (water, herbal tea, clear broths) hydrate mucus loosen. Anti-inflammatory foods ginger fi garlic. Cold drinks fi heavy, greasy meals avoid.",
            medicines = listOf("Antibiotics (bacterial pneumonia: Azithromycin, Amoxicillin, Levofloxacin)", "Antiviral medications (viral pneumonia)", "Antifungal medications (fungal pneumonia)", "Fever reducers/pain relievers (Acetaminophen, Ibuprofen)", "Cough medicine (as directed)", "Oxygen therapy (severe cases)"),
            medicineGuide = "Antibiotics prescribed sirriitti fudhadhaa, feel better after. Early stop infection return fi resistant become. Viral pneumonia, antibiotics help hin taane - rest fi supportive care key. Fever reducers comfort as needed.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Bacterial Pneumonia", description = "Common type, Streptococcus pneumoniae cause. Cold ykn flu after occur."),
                DiseaseType(name = "Viral Pneumonia", description = "Influenza, RSV, ykn coronavirus like viruses cause. Milder often fi serious danda'u."),
                DiseaseType(name = "Mycoplasma Pneumonia", description = "'Walking pneumonia' call. Mycoplasma bacteria cause milder form."),
                DiseaseType(name = "Aspiration Pneumonia", description = "Food, liquid, ykn vomit lungs inhale cause.")
            )
        ),
        Disease(
            id = "typhoid_om",
            name = "Typhoid Fever",
            category = "Infectious",
            definition = "Typhoid fever Salmonella typhi bacteria cause dhiibee serious, contaminated food fi water through spread.",
            symptoms = listOf("Ho'a guddaa (up to 104°F/40°C)", "Weakness fi fatigue", "Stomach pain", "Headache", "Appetite loss", "Rash (rose spots chest/abdomen)", "Constipation ykn diarrhea", "Cough", "Sweating", "Spleen ykn liver enlarged"),
            causes = listOf("Salmonella typhi bacteria", "Contaminated food ykn water", "Sanitation fi hygiene poor", "Infected person contact close", "Endemic areas travel", "Carriers food handle"),
            prevention = listOf("High-risk areas travel before vaccinated", "Bottled ykn boiled water only drink", "Drinks ice avoid", "Thoroughly cooked, hot food only eat", "Raw fruits ykn vegetables unless peeled avoid", "Hands soap frequently wash", "Travel yoo ta'e restaurants carefully choose", "Sanitation good"),
            safetyPractices = listOf("Antibiotics hundaa'aa sirriitti fudhadhaa", "Acute illness during rest", "Dehydration prevent fluids plenty drink", "Hand hygiene strict", "Doctor cleared until others food prepare avoid", "Clearance confirm stool tests follow-up", "Medication side effects report"),
            foodGuidance = "Recovery during easily digestible, nutritious foods eat: boiled rice, bananas, toast, boiled potatoes, yogurt, fi clear soups. Clean water, oral rehydration solutions, ykn coconut water hydrate. Spicy, fatty, ykn heavily seasoned foods avoid. Small, frequent meals eat. Raw foods fi unpasteurized dairy avoid.",
            medicines = listOf("Ciprofloxacin (ykn other fluoroquinolones)", "Azithromycin", "Ceftriaxone (injectable)", "Cefixime", "Carbapenems (resistant cases)"),
            medicineGuide = "Antibiotics prescribed sirriitti fudhadhaa full course (usually 7-14 days). Resistance common, doctor antibiotic choice follow. Home stay others contact avoid cleared until. Carrier no longer confirm stool tests need.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Typhoid Fever (Enteric Fever)", description = "Systemic illness Salmonella typhi cause, prolonged fever fi systemic symptoms."),
                DiseaseType(name = "Paratyphoid Fever", description = "Typhoid similar Salmonella paratyphi cause, usually milder."),
                DiseaseType(name = "Chronic Carrier State", description = "People recovery after bacteria harbor fi shed continue, years for sometimes.")
            )
        ),
        Disease(
            id = "hepatitis_om",
            name = "Hepatitis (Liver Inflammation)",
            category = "Infectious",
            definition = "Hepatitis liver hubachuuf qophaayuu, common viral infections (Hepatitis A, B, C, D, E) cause, alcohol, drugs, ykn autoimmune conditions.",
            symptoms = listOf("Jaundice (skin fi eyes yellow)", "Dark urine", "Pale ykn clay-colored stools", "Fatigue", "Nausea fi vomiting", "Abdominal pain (upper right)", "Appetite loss", "Ho'a", "Joint pain", "Itchy skin"),
            causes = listOf("Viral infection (Hepatitis A, B, C, D, E)", "Alcohol abuse (Alcoholic hepatitis)", "Autoimmune disorders (Autoimmune hepatitis)", "Medications fi toxins", "Fatty liver disease (NAFLD/NASH)", "Blood transfusion (screening before)", "Needles share", "Unsafe sexual practices", "Mother-to-child transmission (Hep B, C)", "Contaminated food/water (Hep A, E)"),
            prevention = listOf("Vaccinated (Hepatitis A fi B)", "Safe sex", "Needles ykn personal items razors share hin taane", "Safe blood transfusions ensure", "Hand hygiene good", "Travel yoo ta'e contaminated food/water avoid", "Alcohol consumption limit", "Medications as directed use", "Risk yoo ta'e test"),
            safetyPractices = listOf("Hepatitis yoo ta'e alcohol completely avoid", "Infected yoo ta'e blood donate hin taane", "Cuts fi wounds cover", "Hepatitis B ykn C yoo ta'e sexual partners inform", "Sex during barrier protection use", "Liver function tests regularly follow-up", "Worsening liver disease signs (confusion, bleeding, swelling) report"),
            foodGuidance = "Liver-friendly diet nyaadhaa: fruits, vegetables, whole grains, fi lean protein plenty. Alcohol completely avoid. Salt, sugar, fi saturated fats limit. Nauseated yoo ta'e small, frequent meals. Antioxidant-rich foods (berries, leafy greens). Raw shellfish avoid. Water hydrate.",
            medicines = listOf("Antiviral medications (Entecavir, Tenofovir Hep B; Sofosbuvir, Ledipasvir Hep C)", "Interferon (Hepatitis B fi C)", "Corticosteroids (autoimmune hepatitis)", "Antirejection medications", "Silymarin (milk thistle - supportive)", "Vaccines (Hepatitis A, B prevention)"),
            medicineGuide = "Hepatitis treatment type by varies. Hepatitis C direct-acting antivirals curable now. Hepatitis B long-term management require. Prescribed sirriitti fudhachuu. Alcohol avoid fi acetaminophen use limit. Liver function regular monitoring essential.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Hepatitis A", description = "Acute viral hepatitis contaminated food/water through spread. Self resolve. Vaccine preventable."),
                DiseaseType(name = "Hepatitis B", description = "Blood fi body fluids through spread viral hepatitis. Acute ykn chronic. Vaccine preventable."),
                DiseaseType(name = "Hepatitis C", description = "Blood-borne viral hepatitis. Chronic become often. Modern antiviral treatment curable now."),
                DiseaseType(name = "Alcoholic Hepatitis", description = "Heavy alcohol use cause liver inflammation. Immediate alcohol cessation require.")
            )
        ),
        Disease(
            id = "asthma_om",
            name = "Asthma",
            category = "Respiratory",
            definition = "Asthma airways narrow, swell, fi extra mucus produce chronic condition, breathing difficult.",
            symptoms = listOf("Shortness breath", "Wheezing (whistling sound breathing out)", "Chest tightness ykn pain", "Cough (night ykn early morning)", "Breathing problems sleep trouble", "Fatigue", "Rapid breathing", "Anxiety ykn panic attacks during"),
            causes = listOf("Dhukkuba aanaa (family history)", "Allergens (dust mites, pollen, pet dander, mold)", "Respiratory infections", "Physical activity (exercise-induced asthma)", "Cold air", "Air pollution fi smoke", "Medications (aspirin, beta blockers)", "Stress fi strong emotions", "Sulfites food", "Occupational exposures (chemicals, dust)"),
            prevention = listOf("Triggers identify fi avoid", "Controller medications prescribed sirriitti fudhadhaa", "Vaccinated flu fi pneumonia", "Peak flow meter breathing monitor", "Healthy weight maintain", "Allergies manage", "Smoke fi air pollution avoid", "Exercise before warm up", "Doctor asthma action plan create"),
            safetyPractices = listOf("Rescue inhaler always carry", "Asthma attack signs know", "Rescue inhaler help hin taane emergency care", "Known triggers avoid", "Inhalers spacer use yoo recommend", "Home dust fi mold free", "Bedding hot water frequently wash", "Taabbaa hin taane fi secondhand smoke avoid"),
            foodGuidance = "Healthy diet fruits, vegetables, fi omega-3 fatty acids (muusaa, walnuts) rich maintain inflammation reduce help. Asthma yoo ta'e sulfites (wine, dried fruit, pickled foods) sensitive people - trigger symptoms yoo ta'e avoid. Healthy weight maintain, obesity asthma worsen. Hydrate.",
            medicines = listOf("Quick-relief (rescue) inhalers: Albuterol, Levalbuterol", "Long-term control medications: Inhaled corticosteroids (Fluticasone, Budesonide)", "Leukotriene modifiers (Montelukast)", "Long-acting beta agonists (LABA)", "Combination inhalers", "Biologics (severe asthma: Omalizumab, Mepolizumab)", "Theophylline"),
            medicineGuide = "Controller medications feel well yoo ta'e daily use - attacks prevent. Rescue inhalers symptoms during immediate relief. Rescue inhaler week twice than use yoo ta'e, asthma well controlled hin taane - doctor. Inhaler technique proper learn.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Allergic Asthma", description = "Common type, allergens pollen, dust mites, pet dander, ykn mold like trigger."),
                DiseaseType(name = "Non-Allergic Asthma", description = "Allergies than other factors trigger: stress, exercise, cold air, infections, ykn irritants."),
                DiseaseType(name = "Exercise-Induced Asthma (EIB)", description = "Physical activity trigger symptoms, usually exercise during ykn short after."),
                DiseaseType(name = "Occupational Asthma", description = "Work keessatti substances exposure cause, chemicals, dust, ykn fumes.")
            )
        ),
        Disease(
            id = "stroke_om",
            name = "Stroke",
            category = "Nervous",
            definition = "Stroke brain part blood flow interrupt ykn reduce, brain tissue oxygen fi nutrients get prevent.",
            symptoms = listOf("Sudden numbness ykn weakness face, arm, ykn leg (one side)", "Sudden confusion ykn speech trouble", "Sudden trouble seeing one ykn both eyes", "Sudden trouble walking, dizziness, ykn balance loss", "Sudden severe headache known cause hin qabu", "Sudden trouble understanding speech", "Sudden severe dizziness", "Face one side drooping", "Coordination loss"),
            causes = listOf("Dhiibbaa dhiigaa (leading cause)", "Cholesterool baay'ee", "Taabbaa", "Diabetes", "Atrial fibrillation (irregular heartbeat)", "Carotid artery disease", "Ulaanaa", "Aktiiifitiivii hin qabu", "Alcohol baay'ise", "Drug abuse (cocaine, amphetamines)", "Dhukkuba aanaa", "Age", "Prior stroke ykn TIA"),
            prevention = listOf("Dhiibbaa dhiigaa hordoffa", "Taabbaa hir'isuu", "Diabetes manage", "Atrial fibrillation treat", "Cholesterool lower", "Healthy weight maintain", "Aktiiifitiivii regularly", "Healthy diet (low salt, low fat) eat", "Alcohol limit", "Prescribed medications (blood thinners, antiplatelets) take", "TIAs (mini-strokes) recognize fi immediately treat"),
            safetyPractices = listOf("EMERGENCY SERVICES CALL IMMEDIATELY - time brain!", "FAST test use: Face drooping, Arm weakness, Speech difficulty, Time call", "Symptoms started note - treatment options affect", "Person anything eat ykn drink give hin taane", "Medical professionals directed unless aspirin give", "Person calm fi comfortable", "Stroke after rehabilitation prepare", "Follow-up appointments all attend"),
            foodGuidance = "DASH ykn Mediterranean diet: low salt (hypertensive yoo ta'e under 1,500 mg/day), saturated fat, fi cholesterol. Fruits, vegetables, whole grains, fi lean proteins plenty. Omega-3 rich foods include. Alcohol limit. Dysphagia exist stroke after, speech therapist dietary recommendations follow.",
            medicines = listOf("Antiplatelets (Aspirin, Clopidogrel)", "Anticoagulants (Warfarin, Apixaban, Rivaroxaban)", "Antihypertensives (dhiibbaa dhiigaa control)", "Statins (cholesterool)", "tPA (tissue plasminogen activator - emergency clot-busting drug)", "Antidiabetic medications", "Anti-seizure medications (post-stroke)"),
            medicineGuide = "Stroke prevention medications prescribed sirriitti fudhadhaa. Antiplatelets fi anticoagulants bleeding risk increase - unusual bruising ykn bleeding report. Dhiibbaa dhiigaa fi cholesterool medications another stroke prevent crucial. Doctor consult without these medications stop hin taane.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Ischemic Stroke", description = "Common type (87%). Brain blood vessel supply clot ykn blockage cause."),
                DiseaseType(name = "Hemorrhagic Stroke", description = "Brain blood vessel leak ykn rupture cause. Dhiibbaa dhiigaa baay'ee ykn aneurysms due."),
                DiseaseType(name = "Transient Ischemic Attack (TIA)", description = "'Mini-stroke' temporary symptoms. Major stroke occur may warning. Immediate medical attention require."),
                DiseaseType(name = "Cryptogenic Stroke", description = "Stroke standard testing after clear cause hin find.")
            )
        ),
        Disease(
            id = "hypertension_om",
            name = "Dhiibbaa Dhiigaa (Hypertension)",
            category = "Heart",
            definition = "Dhiibbaa dhiigaa arteria walls against dhiigaa force consistently too high, heart disease fi stroke risk increase.",
            symptoms = listOf("Often asymptomatic", "Mataa dhukkubbi guddaa", "Hafuura cituu", "Mataa naannessuu", "Fatigue ykn confusion", "Chest pain", "Irregular heartbeat", "Vision changes"),
            causes = listOf("Sodium baay'ee", "Ulaanaa", "Aktiiifitiivii hin qabu", "Taabbba", "Dhukkuba aanaa", "Chronic stress", "Alcohol baay'ee", "Aberaa"),
            prevention = listOf("Sodium hir'isuu", "Aktiiifitiivii (30 min daily)", "Healthy weight maintain", "Taabbba hir'isuu", "Stress manage", "Alcohol limit", "Potassium-rich foods eat"),
            safetyPractices = listOf("Dhiibbaa dhiigaa daily monitor", "Prescribed sirriitti medication take", "Symptomatic yoo ta'e heavy lifting avoid", "Relaxation techniques stress reduce", "Low-sodium diet maintain"),
            foodGuidance = "Potassium-rich foods (bananas, beans, spinach) eat. Processed snacks fi high-sodium foods avoid. Salt flavor instead herbs fi spices use. Alcohol consumption limit. Canned ykn processed options over fresh fruits fi vegetables choose.",
            medicines = listOf("Amlodipine", "Lisinopril", "Hydrochlorothiazide", "Losartan", "Metoprolol"),
            medicineGuide = "Same time daily take. Doctor consult without doses skip hin taane. Dhiibbaa dhiigaa regularly monitor. Feel fine yoo ta'e ta'e abruptly medication stop hin taane.",
            language = "om",
            types = listOf(
                DiseaseType(name = "Primary (Essential) Hypertension", description = "Common type identifiable cause hin qabu. Years many gradually develop."),
                DiseaseType(name = "Secondary Hypertension", description = "Underlying condition cause kidney disease, thyroid problems, ykn medications."),
                DiseaseType(name = "Malignant Hypertension", description = "Severe form organs damage rapidly danda'u very high dhiibbaa dhiigaa. Emergency treatment require.")
            )
        )
    )

    val diseasesAm = listOf(
        Disease(
            id = "heart_hypertension_am",
            name = "የደም ግፊት (Hypertension)",
            category = "Heart",
            definition = "የደም ግፊት በደም ቧንቧዎች ውስጥ ያለው የደም ግፊት መጨመር ነው።",
            symptoms = listOf("ራስ ምታት", "የትንፋሽ ማጠር", "ከፍተኛ ድካም"),
            causes = listOf("ጨው በጣም መጠቀም", "ውፍረት", "ጭንቀት"),
            prevention = listOf("ጨው መቀነስ", "የአካል ብቃት እንቅስቃሴ ማድረግ"),
            safetyPractices = listOf("የደም ግፊትን መለካት", "መድሃኒት በአግባቡ መውሰድ"),
            foodGuidance = "አትክልትና ፍራፍሬ ማዘውተር።",
            medicines = listOf("አሞሊዲን", "ሊሲኖፕሪል"),
            medicineGuide = "መድሃኒቱን በየቀኑ በተመሳሳይ ሰዓት ይውሰዱ።",
            language = "am"
        ),
        Disease(
            id = "skin_eczema_am",
            name = "ኤክሴማ (Skin Disease)",
            category = "Skin",
            definition = "ኤክሴማ ቆዳን የሚያሳክክና የሚያቆስል የቆዳ በሽታ ነው።",
            symptoms = listOf("ማሳከክ", "የቆዳ መቅላት", "የቆዳ መድረቅ"),
            causes = listOf("አለርጂ", "ኬሚካሎች"),
            prevention = listOf("ቆዳን በንፅህና መጠበቅ", "ሎሽን መጠቀም"),
            safetyPractices = listOf("ሽፍታውን አለማከክ", "ወደ ቆዳ ሃኪም መሄድ"),
            foodGuidance = "በቂ ውሃ መጠጣት።",
            medicines = listOf("ሃይድሮኮርቲሶን ክሬም"),
            medicineGuide = "ክሬሙን ንጹህ ቆዳ ላይ በመቀባት ይጠቀሙ።",
            language = "am"
        ),
        Disease(
            id = "gastritis_am",
            name = "ጎስትሪቲስ (Gastritis)",
            category = "Digestive",
            definition = "ጎስትሪቲስ የስኳት መገዳገዳ እና ማጥመዳ የሚያመጣው በኢንፍክሽን፣ በድርቅ መድሃኒት እና በአሽረም መቀነስ ነው።",
            symptoms = listOf("ግርፍ የሆነ የውሃ መርሆ ጉዳት", "ንዝናና እና ማዝያ", "ውሃ መጠን ጉዳት ሲሆን", "የውሃ መርሆ ጉዳት ማጥመዳ", "ረጅም ማድረግ"),
            causes = listOf("ኤች. ፕሎራይ ('H. pylori') መለሰ", "NSAID ድርቅ መድሃኒት ተጠቃሚ", "አሽረም መጠን", "ጥበብ ማስረጃ", "ቡሪስ ርፊሽ"),
            prevention = listOf("መድሃኒትን በትንሽ መጠቀም", "አሽረምን መቀነስ", "ሰዎችን መጠን መጠቀም", "መጠን መጠን መጠቀም", "ጥበብን መቀነስ"),
            safetyPractices = listOf("ረጅም ጉዳት ሲሆን ሃኪም ማድረግ", "ምርመራ መገዳገዳ መጠቀም", "ከሳቅ ጋር መቀበል"),
            foodGuidance = "ውሃ መርሆን በቂ መጠን መጠቀም። ጠንካራ፣ ጠንካራ ወይም ፋሪድ ዳህ፣ ከፍተኛ ደረጃ መጠን መጠቀም። ካፌይን መጠን መከላከል።",
            medicines = listOf("አንታሲድ (ማዕሎክስ)", "አንታሲድ (ሰለዳ)", "ፕሮታን ፕምፕ ማስተካከያ (ኦመፕራዞል)", "አንቲባይኦቲክስ"),
            medicineGuide = "አንታሲድን በመንገድ መጠቀም። ኤች. ፕሎራይን መከላከል ለመጠቀም።",
            language = "am"
        ),
        Disease(
            id = "blood_anemia_am",
            name = "የደም ማነስ (Anemia)",
            category = "Blood",
            definition = "የደም ማነስ በሰውነታችን ውስጥ ቀይ የደም ሴሎች ሲያንሱ የሚከሰት ችግር ነው።",
            symptoms = listOf("ድካም", "የፊት መገረጣት", "ራስ መዞር"),
            causes = listOf("የአይረን እጥረት", "የቫይታሚን እጥረት"),
            prevention = listOf("አይረን ያላቸውን ምግቦች መመገብ", "ምርመራ ማድረግ"),
            safetyPractices = listOf("እረፍት ማድረግ", "በዝግታ መነሳት"),
            foodGuidance = "ቀይ ስጋና ባቄላ መመገብ።",
            medicines = listOf("የአይረን እንክብል"),
            medicineGuide = "የአይረን እንክብልን ከምግብ ጋር መውሰድ ይረዳል።",
            language = "am"
        ),
        Disease(
            id = "peptic_ulcer_am",
            name = "ፔፕቲክ አፈራ (Peptic Ulcer)",
            category = "Digestive",
            definition = "ፔፕቲክ አፈራ ሆኖ የስኳት ገጽታ ላይ ወይም የጥቁር ድንጋይ ግድግዳ ላይ የሚፈጠረው የቀይ ድርቅ መድሃኒትን የሚጠቀም ሲሆን የስኳት ውሃ ማጥመዳ ማድረግን የሚያስፈልጋል።",
            symptoms = listOf("ግርፍ የሆነ የውሃ መርሆ ጉዳት", "ንዝናና እና ማዝያ", "ውሃ መጠን ጉዳት ሲሆን", "የውሃ መርሆ ጉዳት ማጥመዳ", "ረጅም ማድረግ"),
            causes = listOf("ኤች. ፕሎራይ ('H. pylori') መለሰ", "NSAID ድርቅ መድሃኒት ተጠቃሚ", "አሽረም መጠን", "ጥበብ ማስረጃ", "ቡሪስ ርፊሽ"),
            prevention = listOf("መድሃኒትን በትንሽ መጠቀም", "አሽረምን መቀነስ", "ሰዎችን መጠን መጠቀም", "መጠን መጠን መጠቀም", "ጥበብን መቀነስ"),
            safetyPractices = listOf("ረጅም ጉዳት ሲሆን ሃኪም ማድረግ", "ምርመራ መገዳገዳ መጠቀም", "ከሳቅ ጋር መቀበል"),
            foodGuidance = "ውሃ መርሆን በቂ መጠን መጠቀም። ጠንካራ፣ ጠንካራ ወይም ፋሪድ ዳህ፣ ከፍተኛ ደረጃ መጠን መጠቀም። ካፌይን መጠን መከላከል።",
            medicines = listOf("አንታሲድ (ማዕሎክስ)", "አንታሲድ (ሰለዳ)", "ፕሮታን ፕምፕ ማስተካከያ (ኦመፕራዞል)", "አንቲባይኦቲክስ"),
            medicineGuide = "አንታሲድን በመንገድ መጠቀም። ኤች. ፕሎራይን መከላከል ለመጠቀም።",
            language = "am"
        ),
        Disease(
            id = "gerd_am",
            name = "ገርድ (GERD / አሲድ ረፊብ)",
            category = "Digestive",
            definition = "ገርድ ሆኖ የስኳት አሲድ በጥቁር ድንጋይ ግድግዳ ውስጥ መድረሱን የሚያመጣው በስኳት አሲድ መድረሱን የሚያስፈልጋል።",
            symptoms = listOf("ግርፍ የሆነ የውሃ መርሆ ጉዳት", "ንዝናና እና ማዝያ", "ውሃ መጠን ጉዳት ሲሆን", "የውሃ መርሆ ጉዳት ማጥመዳ", "ረጅም ማድረግ"),
            causes = listOf("ኤች. ፕሎራይ ('H. pylori') መለሰ", "NSAID ድርቅ መድሃኒት ተጠቃሚ", "አሽረም መጠን", "ጥበብ ማስረጃ", "ቡሪስ ርፊሽ"),
            prevention = listOf("መድሃኒትን በትንሽ መጠቀም", "አሽረምን መቀነስ", "ሰዎችን መጠን መጠቀም", "መጠን መጠን መጠቀም", "ጥበብን መቀነስ"),
            safetyPractices = listOf("ረጅም ጉዳት ሲሆን ሃኪም ማድረግ", "ምርመራ መገዳገዳ መጠቀም", "ከሳቅ ጋር መቀበል"),
            foodGuidance = "ውሃ መርሆን በቂ መጠን መጠቀም። ጠንካራ፣ ጠንካራ ወይም ፋሪድ ዳህ፣ ከፍተኛ ደረጃ መጠን መጠቀም። ካፌይን መጠን መከላከል።",
            medicines = listOf("አንታሲድ (ማዕሎክስ)", "አንታሲድ (ሰለዳ)", "ፕሮታን ፕምፕ ማስተካከያ (ኦመፕራዞል)", "አንቲባይኦቲክስ"),
            medicineGuide = "አንታሲድን በመንገድ መጠቀም። ኤች. ፕሎራይን መከላከል ለመጠቀም።",
            language = "am"
        ),
        Disease(
            id = "ibs_am",
            name = "አይብሲ (IBS / የመጋረጃ ወርመር ምሽት አይነት)",
            category = "Digestive",
            definition = "አይብሲ ሆኖ የጥቁር ድንጋይ ግድግዳ ላይ የሚፈጠረው የቀይ ድርቅ መድሃኒትን የሚጠቀም ሲሆን የስኳት ውሃ ማጥመዳ ማድረግን የሚያስፈልጋል።",
            symptoms = listOf("ግርፍ የሆነ የውሃ መርሆ ጉዳት", "ንዝናና እና ማዝያ", "ውሃ መጠን ጉዳት ሲሆን", "የውሃ መርሆ ጉዳት ማጥመዳ", "ረጅም ማድረግ"),
            causes = listOf("ኤች. ፕሎራይ ('H. pylori') መለሰ", "NSAID ድርቅ መድሃኒት ተጠቃሚ", "አሽረም መጠን", "ጥበብ ማስረጃ", "ቡሪስ ርፊሽ"),
            prevention = listOf("መድሃኒትን በትንሽ መጠቀም", "አሽረምን መቀነስ", "ሰዎችን መጠን መጠቀም", "መጠን መጠን መጠቀም", "ጥበብን መቀነስ"),
            safetyPractices = listOf("ረጅም ጉዳት ሲሆን ሃኪም ማድረግ", "ምርመራ መገዳገዳ መጠቀም", "ከሳቅ ጋር መቀበል"),
            foodGuidance = "ውሃ መርሆን በቂ መጠን መጠቀም። ጠንካራ፣ ጠንካራ ወይም ፋሪድ ዳህ፣ ከፍተኛ ደረጃ መጠን መጠቀም። ካፌይን መጠን መከላከል።",
            medicines = listOf("አንታሲድ (ማዕሎክስ)", "አንታሲድ (ሰለዳ)", "ፕሮታን ፕምፕ ማስተካከያ (ኦመፕራዞል)", "አንቲባይኦቲክስ"),
            medicineGuide = "አንታሲድን በመንገድ መጠቀም። ኤች. ፕሎራይን መከላከል ለመጠቀም።",
            language = "am"
        ),
        Disease(
            id = "arthritis_am",
            name = "አርትራይቲስ (Arthritis)",
            category = "Musculoskeletal",
            definition = "አርትራይቲስ አንድ ወይም ከዚያ በላይ መገጣጠሚያዎችን የሚያሳክክ ሲሆን ህመም፣ እብጠት እና ውጠት ያመጣል።",
            symptoms = listOf("የመገጣጠሚያ ህመም", "በተለይ ጠዋት ውጠት", "የመገጣጠሚያ እብጠት", "የመገጣጠሚያ ቀይነትና ሙቀት", "የመንቀሳቀስ ማጠር", "ድካም", "ተጣጣፊነት ማጣት"),
            causes = listOf("ኦስቲዮአርትራይቲስ", "ሪውማቶይድ አርትራይቲስ", "ጉት", "ኢንፌክሽኖች", "የቤተሰብ ታሪክ", "ዕድሜ", "ውፍረት", "የቀድሞ የመገጣጠሚያ ጉዳት", "ማጨስ"),
            prevention = listOf("ንቁ ክብደት መጠበቅ", "ቀላል የአካል ብቃት እንቅስቃሴ", "መገጣጠሚያዎችን ከጉዳት መጠበቅ", "በመገጣጠሚያ ዙሪያ ያሉ ጡንቻዎችን ማጠናከር", "የፀረ-እብጠት ምግብ", "ማጨስ ማቆም", "ተደጋጋሚ ጫና መቀነስ"),
            safetyPractices = listOf("ለውጠት ሙቀት፣ ለእብጠት ቅዝቃዜ መጠቀም", "አስፈላጊ ከሆነ የእርዳታ መሳሪያ መጠቀም", "ከረጅም ጊዜ እንቅስቃሴ ማጣት መጠበቅ", "መድሃኒቶችን በትክክል መውሰድ", "ከባድ እብጠት ወይም ትኩሳት ካለ ሃኪም ማማከር"),
            foodGuidance = "የፀረ-እብጠት ምግብ ይመገቡ፡ ኦሜጋ-3 (ዓሳ፣ ዋልነት፣ ፍላክሲድ)፣ ፍራፍሬ፣ አትክልትና ሙሉ እህል። ቀይ ስጋ፣ ስኳር፣ አልኮልና የተሰሩ ምግቦችን ይቀንሱ። ንቁ ክብደት ይጠብቁ።",
            medicines = listOf("የህመም ማስታገሻ (አሴታሚኖፌን)", "NSAIDs (አይቡፕሮፌን፣ ናፕሮክሰን)", "DMARDs (ሜትሮትሬክስት)", "ኮርቲኮስቴሮይድ", "ባዮሎጂካል", "የጉት መድሃኒት"),
            medicineGuide = "የህመምና የፀረ-እብጠት መድሃኒቶችን በትእዛዝ ይውሰዱ። NSAIDs መጠን አይበልጡ። DMARDs መደበኛ የደም ምርመራ ይፈልጋሉ።",
            language = "am",
            types = listOf(
                DiseaseType(name = "Osteoarthritis", description = "በጣም የተለመደው ዓይነት፣ የመገጣጠሚያ ካርቲሌጅ በመሸረሙ የሚመጣ።"),
                DiseaseType(name = "Rheumatoid Arthritis", description = "የራስ-አካል መከላከያ ስርዓት መገጣጠሚያዎችን የሚያ attack ያደርግበት።"),
                DiseaseType(name = "Gout", description = "የዩሪክ አሲድ ክሪስታሎች ከባድ ጥቃት የሚያመጡ፣ ብዙውን ጊዜ በድሮ ጣት።"),
                DiseaseType(name = "Infectious Arthritis", description = "በባክቴሪያ ወይም ቫይረስ የሚመጣ የመገጣጠሚያ ኢንፌክሽን፣ አስቸኳይ ህክምና ይፈልጋል።")
            )
        ),
        Disease(
            id = "back_pain_am",
            name = "የጀርባ ህመም (Back Pain)",
            category = "Musculoskeletal",
            definition = "የጀርባ ህመም ሰዎች ከስራ እንዲቀሩና የአካል ጉዳት እንዲደርስባቸው የሚያደርግ ሲሆን በጡንቻ መሸፈት፣ በተገቢያልኝ አቀማመጥ ወይም በአከርካሪ ችግሮች ይመጣል።",
            symptoms = listOf("በጀርባ ውስጥ የሚያሰቃይ ህመም", "ውጠት ወይም መጠንነት", "አጣዳፊ ህመም", "እስከ እግር የሚወርድ ህመም (ሳያቲካ)", "የመንቀሳቀስ ማጠር", "የጡንቻ መጨፍጨፍ", "በመታጠፍ ወይም በማንሳት የሚባባስ ህመም"),
            causes = listOf("የጡንቻ ወይም ጅማት መሸፈት", "ከባድ ማንሳት", "የተገቢያልኝ አቀማመጥ ወይም ረጅም ቁጭት", "የዲስክ መውጣት", "ስኮሊዮሲስ", "ኦስቲዮፖሮሲስ", "የአከርካሪ አርትራይቲስ", "ውፍረት", "የአካል ብቃት እንቅስቃሴ ማጣት", "ጭንቀት"),
            prevention = listOf("ጥሩ አቀማመጥ", "መደበኛ እንቅስቃሴና መወጠር", "የሆድ ጡንቻዎችን ማጠናከር", "ትክክለኛ የማንሳት ዘዴ (ጉልበት ማጠፍ)", "አማካይ ክብደት", "ረጅም ቁጭት ማስወገድ", "የሚደግፍ ወንበርና ፍራሽ", "ማጨስ ማቆም"),
            safetyPractices = listOf("የሽንት/የሆድ ቁጥጥር ማጣት ወይም የብሽታ መደንዘዝ ካለ አስቸኳይ ህክምና", "የእግር ድካም ማሳወቅ", "ከውድቀት በኋላ የጀርባ ህመም ማሳወቅ", "ከረጅም የአልጋ እረፍት መጠበቅ", "ሙቀት ወይም ቅዝቃዜ መጠቀም"),
            foodGuidance = "ለአጥንት ጤና ካልሲየምና ቫይታሚን ዲ የበለፀገ ምግብ (ወተት፣ አረንጓዴ ቅጠሎች) ይመገቡ። የፀረ-እብጠት ምግቦችን ያካትቱ። በቂ ውሃ ይጠጡ።",
            medicines = listOf("የህመም ማስታገሻ (አሴታሚኖፌን)", "NSAIDs (አይቡፕሮፌን፣ ናፕሮክሰን)", "የጡንቻ ማላላት", "የውጭ ህመም ማስታገሻ", "ፀረ-ጭንቀት (የነርቭ ህመም)", "ኮርቲኮስቴሮይድ መርፌ"),
            medicineGuide = "የህመም መድሃኒቶችን ለአጭር ጊዜ በትእዛዝ ይውሰዱ። NSAIDs ለአረጋውያንና የኩላሊት/ሆድ ችግር ላላቸው በጥንቃቄ። ሥር የሰደደ ህመም ሁለገብ እቅድ ይፈልጋል።",
            language = "am",
            types = listOf(
                DiseaseType(name = "Acute Back Pain", description = "ከ6 ሳምንት ባነሰ ጊዜ የሚቆይ ድንገተኛ ህመም፣ ብዙውን ጊዜ በጡንቻ መሸፈት።"),
                DiseaseType(name = "Chronic Back Pain", description = "ከ12 ሳምንት በላይ የሚቆይ ህመም፣ አንዳንድ ጊዜ ከዲስክ ወይም መገጣጠሚያ ችግር።"),
                DiseaseType(name = "Sciatica", description = "በሳያቲክ ነርቭ ላይ የሚወርድ ህመም፣ ከታችኛው ጀርባ እስከ አንድ እግር።"),
                DiseaseType(name = "Herniated Disc", description = "ዲስክ ወደ ውጭ ወጥቶ ወይም ተሰንጥቆ በነርቭ ላይ ጫና ማድረግ።")
            )
        ),
        Disease(
            id = "osteoporosis_am",
            name = "ኦስቲዮፖሮሲስ (Osteoporosis)",
            category = "Musculoskeletal",
            definition = "ኦስቲዮፖሮሲስ አጥንቶችን ደካማ የሚያደርግ ሲሆን በቀላሉ እንዲሰበሩ ያደርጋል፣ ብዙውን ጊዜ እስከ ስብረት ድረስ ምልክት የለውም።",
            symptoms = listOf("በመጀመሪያ ደረጃ ምልክት የለውም", "በተሰበረ የአከርካሪ አጥንት ምክንያት የጀርባ ህመም", "የቁመት መቀነስ", "የተጠጋጋ አቀማመጥ", "ከቀላል ውድቀት ስብረት", "የሚመለስ ድድ", "ደካማ የመያዝ ጥንካሬ"),
            causes = listOf("ዕድሜና ሆርሞን ለውጥ (ከማህፀን መውጣት በኋላ)", "ዝቅተኛ ካልሲየም አወሳሰድ", "የቫይታሚን ዲ እጥረት", "የአካል ብቃት እንቅስቃሴ ማጣት", "ማጨስ", "ከመጠን በላይ አልኮል", "የኮርቲኮስቴሮይድ ረጅም አጠቃቀም", "የቤተሰብ ታሪክ", "ዝቅተኛ የሰውነት ክብደት"),
            prevention = listOf("በቂ ካልሲየምና ቫይታሚን ዲ ማግኘት", "ክብደት የሚሸከምና ጡንቻ የሚያጠናክር እንቅስቃሴ", "ማጨስ ማቆም", "አልኮል መገደብ", "በቤት ውስጥ ውድቀትን መከላከል", "አማካይ የሰውነት ክብደት", "አደጋ ካለ የአጥንት ጥንካሬ ምርመራ"),
            safetyPractices = listOf("ውድቀትን መከላከል (ምንጣፍ ማንሳት፣ መብራት ማሻሻል)", "ጥሩ አቀማመጥና የአካል ሜካኒክስ", "እንክብሎችን በምክር መውሰድ", "መደበኛ የአጥንት ጥንካሬ ምርመራ", "ድንገተኛ ከባድ የጀርባ ህመም ካለ ሃኪም ማማከር"),
            foodGuidance = "ካልሲየም የበለፀጉ ምግቦች (ወተት፣ እርጎ፣ ቺዝ፣ አረንጓዴ ቅጠሎች) እና የቫይታሚን ዲ ምንጮች (ዓሳ፣ እንቁላል፣ fortified foods) ይመገቡ። ካፌይን፣ ጨውና አልኮል ይቀንሱ።",
            medicines = listOf("የካልሲየምና ቫይታሚን ዲ እንክብሎች", "ቢስፎስፎኔቶች (አሌንድሮኔት)", "ካልሲቶኒን", "ዴኖሱማብ", "ሆርሞን ህክምና", "ተሪፓራታይድ"),
            medicineGuide = "ካልሲየምና ቫይታሚን ዲ እንደተመከረው ብዙውን ጊዜ ከምግብ ጋር ይውሰዱ። ቢስፎስፎኔቶችን በባዶ ሆድ በውሃ ይውሰዱ እና ለ30 ደቂቃ ቀጥ ብለው ይቆዩ። መደበኛ የአጥንት ጥንካሬ ክትትል ይደረግ።",
            language = "am",
            types = listOf(
                DiseaseType(name = "Primary Osteoporosis", description = "ከዕድሜና ከሆርሞን ለውጥ ጋር የተያያዘ፣ በጣም የተለመደ፣ በተለይ ከማህፀን መውጣት በኋላ።"),
                DiseaseType(name = "Secondary Osteoporosis", description = "በሌላ በሽታ ወይም መድሃኒት (ረጅም ስቴሮይድ) የሚመጣ።"),
                DiseaseType(name = "Osteopenia", description = "ከመደበኛ ባነሰ የአጥንት ጥንካሬ ግን ኦስቲዮፖሮሲስ ያልሆነ። የማስጠንቀቂያ ደረጃ።")
            )
        ),
        Disease(
            id = "malaria_am",
            name = "መለናይድ (Malaria)",
            category = "Infectious",
            definition = "መለናይድ በወባ ትንኝ ንክሻ የሚተላለፍ አደገኛ በሽታ ነው።",
            symptoms = listOf("ትኩሳት", "ብርድ", "የራስ ምታት", "ድካም"),
            causes = listOf("የወባ ፓራሳይት", "የወባ ትንኝ ንክሻ"),
            prevention = listOf("አልጋ አጎበር ማዘጋጀት", "ፀረ-ትንኝ መጠቀም"),
            safetyPractices = listOf("ትኩሳት ካለ ወደ ህክምና መሄድ", "መድሃኒቱን መጨረስ"),
            foodGuidance = "ንጹህ ውሃ መጠጣት። አይረን ያላቸውን ምግቦች መመገብ።",
            language = "am"
        )
    )

    private val amDiseaseNames = mapOf(
        "heart_hypertension_en" to "የደም ግፊት (Hypertension)",
        "heart_attack_en" to "የልብ ድንገተኛ ጥቃት (Heart Attack)",
        "skin_eczema_en" to "ኤክሴማ (Eczema)",
        "skin_acne_en" to "አክኔ (Acne)",
        "gastritis_en" to "ጎስትሪቲስ (Gastritis)",
        "peptic_ulcer_en" to "ፔፕቲክ አፈራ (Peptic Ulcer)",
        "gerd_en" to "ገርድ (GERD)",
        "ibs_en" to "አይብሲ (Irritable Bowel Syndrome)",
        "arthritis_en" to "አርትራይቲስ (Arthritis)",
        "back_pain_en" to "የጀርባ ህመም (Back Pain)",
        "osteoporosis_en" to "ኦስቲዮፖሮሲስ (Osteoporosis)",
        "blood_anemia_en" to "የደም ማነስ (Anemia)",
        "malaria_en" to "ወባ (Malaria)",
        "hiv_en" to "ኤችአይቪ/ኤድስ (HIV/AIDS)",
        "diabetes_en" to "ስኳር በሽታ (Diabetes)",
        "cancer_en" to "ካንሰር (Cancer)",
        "heart_disease_en" to "የልብ በሽታ (Heart Disease)",
        "brain_disease_en" to "የአንጎል በሽታ (Brain Disease)",
        "lung_disease_en" to "የሳንባ በሽታ (Lung Disease)",
        "tb_en" to "ቲቢ (Tuberculosis)",
        "pneumonia_en" to "የሳንባ ምች (Pneumonia)",
        "typhoid_en" to "ታይፎይድ (Typhoid Fever)",
        "hepatitis_en" to "ሄፓታይተስ (Hepatitis)",
        "asthma_en" to "አስም (Asthma)",
        "stroke_en" to "ስትሮክ (Stroke)",
        "hypertension_en" to "የደም ግፊት (Hypertension)"
    )

    val diseasesAmDetailed: List<Disease> = (diseasesEn + diseasesEnExtra).map { disease ->
        val baseId = disease.id.removeSuffix("_en")
        disease.copy(
            id = "${baseId}_am",
            name = amDiseaseNames[disease.id] ?: disease.name,
            language = "am"
        )
    }

    fun getDiseases(language: String): List<Disease> {
        return when (language) {
            "om" -> diseasesOm
            "am" -> diseasesAmDetailed
            else -> diseasesEn + diseasesEnExtra
        }
    }

    fun getDiseaseById(id: String, language: String): Disease? {
        val list = getDiseases(language)
        list.find { it.id == id }?.let { return it }
        val genericId = id.substringBeforeLast("_")
        return list.find { it.id.startsWith(genericId) }
    }
}
