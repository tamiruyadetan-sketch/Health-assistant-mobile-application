import re

file_path = r'app\src\main\java\com\example\diseaseinformationhealthassistantmobileapplication\data\DiseaseRepository.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

en_diseases = '''        Disease(
            id = "pneumonia_en",
            name = "Pneumonia",
            category = "Respiratory",
            definition = "Infection that inflames air sacs in one or both lungs, which may fill with fluid.",
            symptoms = listOf("Cough with phlegm or pus", "Fever", "Chills", "Difficulty breathing"),
            causes = listOf("Bacteria", "Viruses", "Fungi"),
            prevention = listOf("Vaccination", "Good hygiene", "Quit smoking"),
            safetyPractices = listOf("Seek medical help if breathing is difficult"),
            foodGuidance = "Warm fluids, honey, vitamin C rich foods.",
            language = "en"
        ),
        Disease(
            id = "hiv_en",
            name = "HIV/AIDS",
            category = "Immune System",
            definition = "A virus that attacks the body's immune system, which can lead to AIDS if untreated.",
            symptoms = listOf("Fever", "Chills", "Rash", "Night sweats", "Fatigue"),
            causes = listOf("Human Immunodeficiency Virus"),
            prevention = listOf("Safe practices", "PrEP", "Using sterile needles"),
            safetyPractices = listOf("Regular testing", "Adherence to antiretroviral therapy (ART)"),
            foodGuidance = "Balanced diet to support immune system.",
            language = "en"
        ),
        Disease(
            id = "covid_en",
            name = "Covid 19",
            category = "Respiratory",
            definition = "A highly contagious respiratory disease caused by the SARS-CoV-2 virus.",
            symptoms = listOf("Fever", "Dry cough", "Tiredness", "Loss of taste or smell"),
            causes = listOf("SARS-CoV-2 virus"),
            prevention = listOf("Vaccination", "Wearing masks", "Hand hygiene", "Social distancing"),
            safetyPractices = listOf("Isolate if symptomatic", "Seek emergency care for trouble breathing"),
            foodGuidance = "Stay hydrated, eat nutritious foods to support immunity.",
            language = "en"
        ),
        Disease(
            id = "tb_en",
            name = "Tuberculosis",
            category = "Infectious",
            definition = "A potentially serious infectious bacterial disease that mainly affects the lungs.",
            symptoms = listOf("Persistent cough", "Chest pain", "Coughing up blood", "Fatigue"),
            causes = listOf("Mycobacterium tuberculosis"),
            prevention = listOf("BCG vaccination", "Avoiding close contact with infected individuals"),
            safetyPractices = listOf("Complete the long course of antibiotics as prescribed"),
            foodGuidance = "High-protein, high-calorie diet with plenty of vitamins.",
            language = "en"
        ),
        Disease(
            id = "flu_en",
            name = "Influenza",
            category = "Respiratory",
            definition = "A common viral infection that can be deadly, especially in high-risk groups.",
            symptoms = listOf("Fever", "Chills", "Muscle aches", "Cough", "Congestion"),
            causes = listOf("Influenza viruses"),
            prevention = listOf("Annual flu vaccine", "Hand washing"),
            safetyPractices = listOf("Rest", "Stay home to prevent spreading"),
            foodGuidance = "Warm liquids, easily digestible foods.",
            language = "en"
        ),
        Disease(
            id = "cholera_en",
            name = "Cholera",
            category = "Infectious",
            definition = "A bacterial disease causing severe diarrhea and dehydration, usually spread in water.",
            symptoms = listOf("Severe watery diarrhea", "Vomiting", "Leg cramps"),
            causes = listOf("Vibrio cholerae bacterium"),
            prevention = listOf("Drink safe water", "Wash hands", "Cook food well"),
            safetyPractices = listOf("Immediate rehydration is critical"),
            foodGuidance = "Oral Rehydration Salts (ORS), boiled water, simple foods after rehydration.",
            language = "en"
        ),
        Disease(
            id = "hypertension_en",
            name = "Hypertension",
            category = "Cardiovascular",
            definition = "A condition in which the force of the blood against the artery walls is too high.",
            symptoms = listOf("Often none", "Headaches", "Shortness of breath", "Nosebleeds"),
            causes = listOf("Genetics", "High salt intake", "Obesity", "Stress", "Lack of exercise"),
            prevention = listOf("Low salt diet", "Regular exercise", "Maintain healthy weight"),
            safetyPractices = listOf("Regular blood pressure monitoring", "Take prescribed medications"),
            foodGuidance = "DASH diet, reduce sodium.",
            language = "en"
        ),
        Disease(
            id = "measles_en",
            name = "Measles",
            category = "Infectious",
            definition = "A highly contagious viral infection that's serious for small children but easily preventable by a vaccine.",
            symptoms = listOf("Fever", "Dry cough", "Runny nose", "Sore throat", "Skin rash"),
            causes = listOf("Measles virus"),
            prevention = listOf("MMR vaccine"),
            safetyPractices = listOf("Isolate patient", "Seek medical advice"),
            foodGuidance = "Vitamin A rich foods, plenty of fluids.",
            language = "en"
        )'''

om_diseases = '''        Disease(
            id = "pneumonia_om",
            name = "Nimooniyaa (Pneumonia)",
            category = "Respiratory",
            definition = "Infeekshinii sombaa kan qilleensa sombaa miidhu fi dhangala'aan akka guutu taasisu.",
            symptoms = listOf("Qufaa", "Ho'a qaamaa", "Hafuura gabaabuu"),
            causes = listOf("Baakteeriyaa", "Vaayirasii"),
            prevention = listOf("Tallaallii", "Qulqullina eeguu"),
            safetyPractices = listOf("Mana yaalaa deemuu"),
            foodGuidance = "Dhangala'aa ho'aa dhuguu.",
            language = "om"
        ),
        Disease(
            id = "hiv_om",
            name = "HIV/AIDS",
            category = "Immune System",
            definition = "Vaayirasii sirna ittisa qaamaa dadhabsiisu.",
            symptoms = listOf("Ho'a qaamaa", "Dadhabbi", "Ulfaatina hir'isuu"),
            causes = listOf("Vaayirasii HIV"),
            prevention = listOf("Of eeggannoo", "Tallaallii hin qabu, haala jireenyaa eeguu"),
            safetyPractices = listOf("Qorannoo gochuu", "Qoricha farra HIV fudhachuu"),
            foodGuidance = "Nyaata madaalawaa soorachuu.",
            language = "om"
        ),
        Disease(
            id = "covid_om",
            name = "Covid 19",
            category = "Respiratory",
            definition = "Dhibee sombaa daddarbaa vaayirasii koroonaatiin dhufu.",
            symptoms = listOf("Qufaa gogaa", "Ho'a qaamaa", "Urgooftuu dhabuu"),
            causes = listOf("Vaayirasii SARS-CoV-2"),
            prevention = listOf("Maaskii godhachuu", "Harka dhiqachuu"),
            safetyPractices = listOf("Kophaa ta'uu", "Mana yaalaa deemuu"),
            foodGuidance = "Nyaata gaarii nyaachuu fi bishaan dhuguu.",
            language = "om"
        ),
        Disease(
            id = "tb_om",
            name = "Tuberculosis (TB)",
            category = "Infectious",
            definition = "Dhibee daddarbaa baakteeriyaatiin dhufu kan irra caalaa somba miidhu.",
            symptoms = listOf("Qufaa yeroo dheeraa", "Laphee dhukkubuu"),
            causes = listOf("Baakteeriyaa TB"),
            prevention = listOf("Tallaallii BCG"),
            safetyPractices = listOf("Qoricha guutuu fudhachuu"),
            foodGuidance = "Nyaata ijaarsa qaamaaf gaarii ta'e soorachuu.",
            language = "om"
        ),
        Disease(
            id = "flu_om",
            name = "Influenza",
            category = "Respiratory",
            definition = "Infeekshinii vaayirasii kan yeroo baay'ee namatti dhufu.",
            symptoms = listOf("Ho'a qaamaa", "Qufaa", "Mataa dhukkubuu"),
            causes = listOf("Vaayirasii fuluu"),
            prevention = listOf("Tallaallii", "Qulqullina"),
            safetyPractices = listOf("Boqochuu"),
            foodGuidance = "Dhangala'aa dhuguu.",
            language = "om"
        ),
        Disease(
            id = "cholera_om",
            name = "Koleraa",
            category = "Infectious",
            definition = "Dhibee baakteeriyaatiin dhufu kan garaa kaasaa hamaa fidu.",
            symptoms = listOf("Garaa kaasaa bishaanoo", "Haqqee"),
            causes = listOf("Baakteeriyaa"),
            prevention = listOf("Bishaan qulqulluu dhuguu", "Harka dhiqachuu"),
            safetyPractices = listOf("Bishaan qaamaa bakka buusuu (ORS)"),
            foodGuidance = "ORS fi bishaan danfisuun dhuguu.",
            language = "om"
        ),
        Disease(
            id = "hypertension_om",
            name = "Dhiibbaa Dhiigaa (Hypertension)",
            category = "Cardiovascular",
            definition = "Haala dhiibbaan dhiigaa ujummoo dhiigaa keessatti ol ka'u.",
            symptoms = listOf("Mataa dhukkubuu", "Hafuura gabaabuu (yeroo baay'ee mallattoo hin qabu)"),
            causes = listOf("Soogidda baay'isuu", "Sanyii", "Furdi guddaa"),
            prevention = listOf("Soogidda hir'isuu", "Sochii qaamaa gochuu"),
            safetyPractices = listOf("Dhiibbaa dhiigaa madaaluu", "Qoricha fudhachuu"),
            foodGuidance = "Soogidda hir'isuu.",
            language = "om"
        ),
        Disease(
            id = "measles_om",
            name = "Kufaa (Measles)",
            category = "Infectious",
            definition = "Dhibee vaayirasii daddarbaa kan ijoolee miidhu.",
            symptoms = listOf("Ho'a qaamaa", "Qufaa", "Gogaa irratti ba'uu"),
            causes = listOf("Vaayirasii kufaa"),
            prevention = listOf("Tallaallii MMR"),
            safetyPractices = listOf("Kophaa eeguu"),
            foodGuidance = "Viitaamiinii A fi bishaan dhuguu.",
            language = "om"
        )'''

am_diseases = '''        Disease(
            id = "pneumonia_am",
            name = "ኒሞኒያ (Pneumonia)",
            category = "የመተንፈሻ አካላት",
            definition = "የሳንባን አየር ከረጢቶች የሚያጠቃ ኢንፌክሽን።",
            symptoms = listOf("ሳል", "ትኩሳት", "የመተንፈስ ችግር"),
            causes = listOf("ባክቴሪያ", "ቫይረስ"),
            prevention = listOf("ክትባት", "ንፅህናን መጠበቅ"),
            safetyPractices = listOf("የህክምና እርዳታ ማግኘት"),
            foodGuidance = "ትኩስ ፈሳሽ መጠጣት።",
            language = "am"
        ),
        Disease(
            id = "hiv_am",
            name = "ኤች አይ ቪ/ኤድስ (HIV/AIDS)",
            category = "የበሽታ መከላከያ",
            definition = "የሰውነትን በሽታ መከላከያ ስርአት የሚያጠቃ ቫይረስ።",
            symptoms = listOf("ትኩሳት", "ድካም", "የክብደት መቀነስ"),
            causes = listOf("ኤች አይ ቪ ቫይረስ"),
            prevention = listOf("ጥንቃቄ ማድረግ", "የህክምና ምክር መከተል"),
            safetyPractices = listOf("ምርመራ ማድረግ", "መድሃኒት (ART) መውሰድ"),
            foodGuidance = "ተመጣጣኝ ምግብ መመገብ።",
            language = "am"
        ),
        Disease(
            id = "covid_am",
            name = "ኮቪድ 19 (Covid 19)",
            category = "የመተንፈሻ አካላት",
            definition = "በኮሮና ቫይረስ የሚመጣ ተላላፊ የመተንፈሻ አካላት በሽታ።",
            symptoms = listOf("ደረቅ ሳል", "ትኩሳት", "የማሽተት ችሎታ ማጣት"),
            causes = listOf("የኮሮና ቫይረስ"),
            prevention = listOf("ማስክ ማድረግ", "እጅ መታጠብ", "ርቀት መጠበቅ"),
            safetyPractices = listOf("ለይቶ ማቆያ መግባት"),
            foodGuidance = "ፈሳሽ መጠጣት እና ጤናማ ምግብ መመገብ።",
            language = "am"
        ),
        Disease(
            id = "tb_am",
            name = "ሳንባ ነቀርሳ (Tuberculosis)",
            category = "ተላላፊ በሽታ",
            definition = "በአብዛኛው ሳንባን የሚያጠቃ አደገኛ የባክቴሪያ በሽታ።",
            symptoms = listOf("የረጅም ጊዜ ሳል", "የደረት ህመም"),
            causes = listOf("ቲቢ ባክቴሪያ"),
            prevention = listOf("ክትባት (BCG)"),
            safetyPractices = listOf("መድሃኒቱን ሳይቋርጡ መውሰድ"),
            foodGuidance = "በፕሮቲን የበለፀገ ምግብ መመገብ።",
            language = "am"
        ),
        Disease(
            id = "flu_am",
            name = "ጉንፋን (Influenza)",
            category = "የመተንፈሻ አካላት",
            definition = "በቫይረስ የሚመጣ የተለመደ የመተንፈሻ አካላት ኢንፌክሽን።",
            symptoms = listOf("ትኩሳት", "ሳል", "የሰውነት ህመም"),
            causes = listOf("የጉንፋን ቫይረሶች"),
            prevention = listOf("ክትባት", "እጅ መታጠብ"),
            safetyPractices = listOf("እረፍት ማድረግ"),
            foodGuidance = "ትኩስ ፈሳሽ መጠጣት።",
            language = "am"
        ),
        Disease(
            id = "cholera_am",
            name = "አተት (Cholera)",
            category = "ተላላፊ በሽታ",
            definition = "ከባድ ተቅማጥና ማስመለስ የሚያስከትል የባክቴሪያ በሽታ።",
            symptoms = listOf("ከባድ የውሃ ተቅማጥ", "ማስመለስ"),
            causes = listOf("የኮሌራ ባክቴሪያ"),
            prevention = listOf("ንፁህ ውሃ መጠጣት", "እጅ መታጠብ"),
            safetyPractices = listOf("ወዲያውኑ ፈሳሽ መተካት (ORS)"),
            foodGuidance = "የተቀቀለ ውሃ እና ኦአርኤስ (ORS) መጠጣት።",
            language = "am"
        ),
        Disease(
            id = "hypertension_am",
            name = "የደም ግፊት (Hypertension)",
            category = "ልብና የደም ዝውውር",
            definition = "በደም ቧንቧዎች ውስጥ ያለው የደም ግፊት መጨመር።",
            symptoms = listOf("የራስ ምታት (አብዛኛውን ጊዜ ምልክት አያሳይም)"),
            causes = listOf("ብዙ ጨው መጠቀም", "ውፍረት"),
            prevention = listOf("ጨው መቀነስ", "የአካል ብቃት እንቅስቃሴ"),
            safetyPractices = listOf("የደም ግፊትን በቋሚነት መለካት"),
            foodGuidance = "ጨው እና ስብን መቀነስ።",
            language = "am"
        ),
        Disease(
            id = "measles_am",
            name = "ኩፍኝ (Measles)",
            category = "ተላላፊ በሽታ",
            definition = "በተለይ ህፃናትን የሚያጠቃ ተላላፊ የቫይረስ በሽታ።",
            symptoms = listOf("ትኩሳት", "ሳል", "የቆዳ ላይ ሽፍታ"),
            causes = listOf("የኩፍኝ ቫይረስ"),
            prevention = listOf("ክትባት (MMR)"),
            safetyPractices = listOf("ህክምና ማግኘት እና ለይቶ ማቆየት"),
            foodGuidance = "ቫይታሚን ኤ እና በቂ ፈሳሽ መውሰድ።",
            language = "am"
        )'''

# Insert english
match = re.search(r'val diseasesEn = listOf\(([\s\S]*?)\n    \)', content)
if match:
    existing_en = match.group(1)
    new_en = existing_en + ",\n" + en_diseases
    content = content.replace(match.group(0), f'val diseasesEn = listOf({new_en}\n    )')

# Insert oromo
match = re.search(r'val diseasesOm = listOf\(([\s\S]*?)\n    \)', content)
if match:
    existing_om = match.group(1)
    new_om = existing_om + ",\n" + om_diseases
    content = content.replace(match.group(0), f'val diseasesOm = listOf({new_om}\n    )')

# Insert amharic
match = re.search(r'val diseasesAm = listOf\(([\s\S]*?)\n    \)', content)
if match:
    existing_am = match.group(1)
    new_am = existing_am + ",\n" + am_diseases
    content = content.replace(match.group(0), f'val diseasesAm = listOf({new_am}\n    )')

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)
print("Done")
