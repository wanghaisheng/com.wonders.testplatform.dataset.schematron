<?xml version="1.0" encoding="UTF-8"?>
<table>
  <line>| 源文档标识 | 原始表达式 | QIDAM表达式 |</line>
  <line>| NQF 0068 | Procedure, Performed: Percutaneous Coronary Interventions&lt;= 12 month(s) ends before start of "Measurement Period"using "Percutaneous Coronary Interventions Grouping Value Set (2.16.840.1.113883.3.464.1003.104.12.1010) | modality Observation |</line>
  <line>| NQF 0068 | Medication, Active: Aspirin and Other Anti-thrombotics" ends before start of "Measurement Period | StatementOfOccurrence with�topic Procedure |</line>
  <line>| NQF 0440 | Encounter, Performed: Non-Elective Inpatient Encounter (admission datetime)" &lt;= 1 hour(s) starts after end of "Occurrence A of Encounter, Performed: Emergency Department Visit (facility location departure datetime)" | - procedureCode in PCI Grouping VS |</line>
  <line>| NQF 0002 | "Laboratory Test, Result: Group A Streptococcus Test (result)" &lt;= 3 day(s) starts before or during "Occurrence A of Encounter, Performed: Ambulatory/ED Visit" | modality Performance�- performanceTime ends &lt;= 12 months before start of "Measurement period" |</line>
  <line>| NQF 0565 | "Physical Exam, Finding: Best Corrected Visual Acuity (result: 'Visual acuity 20/40 or Better')" &lt;= 90 day(s) starts after end of "Occurrence A of Procedure, Performed: Cataract Surgery" | StatementOfOccurrence with�topic MedicationTreatment�- medication in ASA+AT Grouping VS�modality Performance |</line>
  <line>| NQF 0018 | "Physical Exam, Finding: Systolic Blood Pressure (result &lt; 140 mmHg)"during MOST RECENT: "Encounter, Performed: Office Visit" | - performanceTime ends &lt;= start of "Measurement period" |</line>
  <line>| NQF 0059 | Laboratory Test, Result: HbA1c Laboratory Test" during "Measurement Period"AND: "Occurrence A of Laboratory Test, Result: HbA1c Laboratory Test (result &gt; 9 %)" | -actionPerformed = MedicationRegimen |</line>
  <line>| NQF 1659 | "Procedure, Performed not done: Drug not available" during "Occurrence A of Encounter, Performed: Encounter Inpatient"  | StatementOfOccurrence with�topic Encounter�-serviceType in Non-Elective Inpatient Encounter VS�modality Performance |</line>
  <line>| NQF 528 | "Medication, Administered: Hospital measures-IV Vancomycin (route: "Hospital measures-Route IV")" &lt;=1440 minutes(s) starts before start of "Occurrence A of Procedure, Performed: Hospital measures-Joint Commission evidence of a surgical procedure requiring general or neuraxial anesthesia (incision datetime)"  | -performanceTime begins &lt;=1 hour after end of "Encounter, Performed: Emergency Department Visit" |</line>
  <line>| https://www.icsi.org/_asset/dwy1nl/ACSOS1112.doc | Glucose by finger stick screening 4 times daily (before meals and at bedtime) for 24 hours | StatementOfOccurrence with�topic MicrobiologySensitivityResult�-name in Group A Streptococcus Test VS�modality Observation |</line>
  <line>| https://www.icsi.org/_asset/dwy1nl/ACSOS1112.doc | Ticagrelor180 mg loading dose by mouth once90 mg by mouth twice daily | -observedAtTime  &lt;=3 days before "Encounter, Performed: Ambulatory/ED visit" |</line>
  <line>| NQF 0070 | Medication Adverse Event to Beta Blocker Therapy. | StatementOfOccurrence with�topic SimpleObservationResult�-name in Best Corrected Visual Acuity VS�-value &gt; code for Visual acuity 20/40�modality Observation  |</line>
  <line>| NQF 0055 | Medication dispensed:Medications indicativeof diabetes  &lt;= 2 yearsbefore or simultaneously to“Measurement end date”. | -observedAtTime &lt;=90 days after" Procedure, performed: Cataract surgery" |</line>
  <line>| Corticosteroid inhaler reminder | Allergy To inhaled corticosteroids | StatementOfOccurrence with�topic SimpleObservationResult�- name in Systolic BP VS�- value &lt; 140 mm Hg�modality Observation  |</line>
  <line>| Heart Failure Admission ToMedSurgOrderSets | Not allergic to an ACE inhibitor. | - observedAtTime within (mostRecentOfficeVisitEnc.performanceTime) |</line>
  <line>| CMS 147v2 | Communication from patient to provider: Previous receipt of influenza vaccine | StatementOfOccurrence with�topic SimpleObservationResult�-name in HbA1c Laboratory Test in |</line>
  <line>|  | Family History Of breast cancer in mother. | -value &gt; 9%�modality Observation  |</line>
  <line>| NQF0038 | "Medication administered: rubella vaccine", occurring &lt;2 years after "Patient characteristic: birth date | -observedAtTime within measurement period |</line>
  <line>| CMS135v1 | "Medication, Allergy: ACE inhibitor or ARB Allergen"(http://ushik.org/ViewItemDetails?&amp;system=mu&amp;itemKey=161732000&amp;enableAsynchronousLoading=true#qde_161734000) | StatementOfNonOccurrence with�topic Procedure |</line>
  <line>| CMS142v1 | Communication: From Provider to Provider: Level of Severity of Retinopathy Findings(http://ushik.org/ViewItemDetails?&amp;system=mu&amp;itemKey=162036000&amp;enableAsynchronousLoading=true#qde_162048000) | -currentStatus = { |</line>
  <line>| CMS73v1 | Medication, Administered: Parenteral Anticoagulant(http://ushik.org/ViewItemDetails?&amp;system=mu&amp;itemKey=161140000&amp;enableAsynchronousLoading=true#qde_161150000) |   -reason=“Drug not available” |</line>
  <line>| CMS73v1 | Laboratory Test, Result: INR�(result&lt;2)(http://ushik.org/ViewItemDetails?&amp;system=mu&amp;itemKey=161140000&amp;enableAsynchronousLoading=true#qde_161145000) | } |</line>
  <line>| USPSTF Screening for Syphilis Infection In Pregnancy | Screen for syphilis infections | modality Performance |</line>
  <line>| CMS135v2 | Encounter, Performed: Care Services in Long-Term Residential Facility during   Measurement Period(http://ushik.org/ViewItemDetails?&amp;system=mu&amp;itemKey=161732000&amp;enableAsynchronousLoading=true#qde_161741000) | -occurredDuring = "Encounter, Performed: Encounter Inpatient |</line>
  <line>| CMS190v1 | Device, Applied not done: Patient Refusal  for Graduated compression stockings (GCS)(https://ushik.ahrq.gov/details?itemKey=160837000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_160876000) | StatementOfOccurrence with�topic MedicationTreatment�-medication in IV Vancomycin VS�-dosage {deliveryRoute in Hospital measures-Route IV VS}�modality Performance |</line>
  <line>| CMS178v2 | Device, Applied: Hospital Measures-Indwelling urinary catheter�(https://ushik.ahrq.gov/details?itemKey=160677000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_160682000) | -performanceTime.begin&lt;=1440 minute(s) before (Procedure, Performed: Hospital measures-Joint commission evidence of a surgical procedure requiring general or neuraxial anesthesia" - performanceTime.begin) |</line>
  <line>| CMS157v1 | Occurrence A of�Diagnosis, Active: Cancer(https://ushik.ahrq.gov/details?itemKey=162435000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_162440000) | -actionPerformed: DoseAdministration |</line>
  <line>| Acute Coronary Syndrome, Admission to CCU for - https://www.icsi.org/_asset/dwy1nl/ACSOS1112.doc | Consistent carbohydrate (CHO)Diet | StatementOfOccurrence with |</line>
  <line>| USPSTF Routine Screening for Iron Deficiency Anemia in Asymptomatic Pregnant Women | recommends routine screening for iron deficiency anemia | topic Procedure�-procedureCode in Glucose Measurement by Finger stick screening VS�-procedureSchedule=4 times daily (before meals and at bedtime) for 24 hrs |</line>
  <line>| CMS114v1 | Medication, Administered not done: Medical Contraindication" for "Injectable Factor Xa Inhibitor(https://ushik.ahrq.gov/details?itemKey=160451000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_160472000) | modality Proposal |</line>
  <line>| CMS157v1 | Procedure, Performed: Chemotherapy Administration(https://ushik.ahrq.gov/details?itemKey=162435000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_162438000) | StatementOfOccurrence with�topic MedicationTreatment�-medication in Ticagrelor VS�-dosage {� { |</line>
  <line>| CMS53v1 | Diagnostic Study, Result: Hospital Measures-ECG Impression(https://ushik.ahrq.gov/details?itemKey=160997000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_161014000) |   - doseType=loadingDose�  - route=oral�  - doseQuantity=180 mg�  - schedule=Once on day 1�   } |</line>
  <line>| CMS136v2 | Encounter, Performed: Discharge Services- Observation Care(https://ushik.ahrq.gov/details?itemKey=161771000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_161782000) |  { �  - deliveryRoute=oral�  - doseQuantity=90 mg�  - administrationSchedule=twice daily starting day 2 |</line>
  <line>| HL7 V3 DAM, Diet and Nutrition Orders, DSTU Release 2 | a standard, polymeric enteral formula was selected from the hospital’s established formulary, and a total energy target of 20–25 kcal per kg actual body weight  |   } |</line>
  <line>| Stroke for Patient not Receiving tPA, Ischemic; Admission for -  https://www.icsi.org/_asset/gd1yy3/StrokeOSnontPA0712.doc | keep patient with nothing by mouth | modality Proposal |</line>
  <line>| CMS113v1 | Diagnosis, Active: Spontaneous Rupture of Membranes(https://ushik.ahrq.gov/ViewItemDetails?&amp;system=mu&amp;itemKey=160421000&amp;enableAsynchronousLoading=true#qde_160433000) | StatementOfOccurrence with |</line>
  <line>| QIDAM developers | Patient is not pregnant. | topic AdverseReaction |</line>
  <line>| QIDAM developers | Unknown if patient has history of�rheumatic fever | -exposure.stimulus in Beta Blocker VS |</line>
  <line>| QIDAM developers | Patient is advised to wear holter monitor | modality Observation |</line>
  <line>| QIDAM developers | Begin NTP (Non-Invasive Transcutaneous Pacing) immediately by trained nurse | StatementOfOccurrence with |</line>
  <line>| QIDAM developers | Cholecystectomy was not performed | topic MedicationTreatment |</line>
  <line>| QIDAM developers | Hep B dose 1 due now. Total of 3 doses required to obtain protection from Hepatitis B infection.  | - medication in medications indicative of diabetes VS |</line>
  <line>| QIDAM developers | Aspirin 81 mg ,one tablet per day orally | modality Performance |</line>
  <line>| QIDAM developers | Lumpectomy is contraindicated in pregnancy | -actionPerformed = Dispense |</line>
  <line>| QIDAM developers | No family history of lung cancer in patient | -performanceTime &lt;=2years before or simultaneously to “measurement end date” |</line>
  <line>| San Diego County Pertussis Notification Criteria | Phone epidemiology program at SDDHS | StatementOfOccurrence with |</line>
  <line>| QIDAM developers | notify MD if temperature goes above 104 F | topic AllergyIntolerance |</line>
  <line>| QIDAM developers | Unknown whether patient has Penicillin allergy | -stimulus in corticosteroids VS |</line>
  <line>| QIDAM developers | Patient receiving chemotherapy did not respond to first line medications | -sensitivityType=Allergy |</line>
  <line>| QIDAM developers | Participation in a government guarantee program for immunizations (e.g., Vaccines for Children) impacts which vaccine stock is used to treat the patient | modality Observation |</line>
  <line>| QIDAM developers | Recommend HbA1c of less than 6.5% within next 3 months. | StatementOfNonOccurrence with  |</line>
  <line>| QIDAM developers | Goal of LDL level of 100 mg/dL has been established | topic AllergyIntolerance  |</line>
  <line>| QIDAM developers | There are ventilators present in this long-term care facility. | -stimulus in ACE inhibitor VS |</line>
  <line>| VMR | Increased fiber diet | -sensitivityType=Allergy  |</line>
  <line>| VMR | High-calorie protein shake | modality Observation |</line>
  <line>| VMR | Easy to chew diet (regime/therapy) | StatementOfOccurrence with  |</line>
  <line>| CMS100v1 | Transfer To: Hospital Measures - Inpatient Hospice Care(https://ushik.ahrq.gov/ViewItemDetails?&amp;system=mu&amp;itemKey=160114000&amp;enableAsynchronousLoading=true#qde_160121000) | topic Communication  |</line>
  <line>| USPSTF Screening for Hepatitis B Virus Infection in Pregnancy | High risk patients and patients who test positive for HBV should be referred to an appropriate case-management program. | -recipient=provider |</line>
  <line>| CMS188v2 | Diagnosis, Inactive: Cystic Fibrosis(http://ushik.org/ViewItemDetails?&amp;system=mu&amp;itemKey=160754000&amp;enableAsynchronousLoading=true#qde_160805000) | -sender=patient |</line>
  <line>| CMS 160v1 | "Patient Characteristic Expired: Deceased"(https://ushik.ahrq.gov/details?itemKey=162499000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_162504000) | -relatedStatement: {StatementOfOccurrence reference for influenza vaccine admin} |</line>
  <line>| CMS 171v2 | Device, Applied: Hospital measures-Pacemaker or implantable defibrillator device"(http://ushik.org/ViewItemDetails?&amp;system=mu&amp;itemKey=160501000&amp;enableAsynchronousLoading=true#qde_160525000) | } |</line>
  <line>| CMS22v1 | Intervention, Order: Referral to Alternative Provider / Primary Care Provider (reason: 'Finding of Hypertension')(http://ushik.org/ViewItemDetails?&amp;system=mu&amp;itemKey=162796000&amp;enableAsynchronousLoading=true#qde_162806000) | modality Performance |</line>
  <line>| CMS155v1 | Intervention, Performed: Counseling for Physical Activity(https://ushik.ahrq.gov/details?itemKey=162381000&amp;System=mu&amp;enableAsynchronousLoading=true#qde_162395000) | StatementOfOccurrence with |</line>
  <line>| QIDAM Developers | Migraine triggered by bright light | topic FamilyHistory |</line>
  <line>| CMS64v3 | Risk Category Assessment: Framingham coronary heart disease 10 year risk (result &gt; 20 %)" during "Measurement Period” | -relationship=mother |</line>
  <line>|  |  | -condition= Breast Cancer |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Immunization |</line>
  <line>|  |  | -vaccine.vaccineType in Rubella Vaccine VS  |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | -performanceTime= &lt;2years after birth date |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic AllergyIntolerance |</line>
  <line>|  |  | -sensitivityType=Allergy |</line>
  <line>|  |  | -stimulus in ACE inhibitor or ARB Allergen VS  |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with  |</line>
  <line>|  |  | topic Communication |</line>
  <line>|  |  | -recipient=provider |</line>
  <line>|  |  | -sender=provider |</line>
  <line>|  |  | -message=“ObservationResult statement containing level of severity of retinopathy findings”  |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with  |</line>
  <line>|  |  | topic MedicationTreatment  |</line>
  <line>|  |  | -medication in Parenteral Anticoagulant VS  |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | -actionPerformed = MedicationRegimen |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic SimpleObservationResult |</line>
  <line>|  |  | -value &lt;2 |</line>
  <line>|  |  | -name in INR VS |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Procedure |</line>
  <line>|  |  | -procedureCode in Screening Test for Syphilis Infection VS  |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Encounter |</line>
  <line>|  |  | -location.function=Long-Term Residential Facility |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | -performedanceTime=during Measurement Period |</line>
  <line>|  |  | StatementOfNonOccurrence with |</line>
  <line>|  |  | topic DeviceUse |</line>
  <line>|  |  | -device.type in Graduated compression stockings VS |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | -currentStatus.reason=patient refusal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic DeviceUse |</line>
  <line>|  |  | -device.type in Indwelling urinary catheter VS  |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Condition |</line>
  <line>|  |  | -name in Active Cancer VS |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Diet |</line>
  <line>|  |  | -nutritionItem[OralDiet].dietType= carbohydrates |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Procedure |</line>
  <line>|  |  | -procedureCode in screening test for iron deficiency anemia VS |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfNonOccurrence with |</line>
  <line>|  |  | topic MedicationTreatment |</line>
  <line>|  |  | -medication.code in Injectable Factor Xa VS |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | -currentStatus.reason=MedicalContraindication |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Procedure |</line>
  <line>|  |  | -procedureCode in Chemotherapy Administration VS |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic ObservationResult |</line>
  <line>|  |  | -name in ECG-Impression |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Encounter |</line>
  <line>|  |  | -serviceType in Discharge services Observation care VS |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with  |</line>
  <line>|  |  | topic Diet |</line>
  <line>|  |  | -nutritionItem= |</line>
  <line>|  |  |   {EnteralFormula with |</line>
  <line>|  |  |      -caloricDensity=20–25 kcal per kg |</line>
  <line>|  |  |      -product=standard, polymeric enteral formula |</line>
  <line>|  |  |   }  |</line>
  <line>|  |  | modality Order |</line>
  <line>|  |  | StatementOfOccurrence with  |</line>
  <line>|  |  | topic Diet |</line>
  <line>|  |  | -nutrititionItem[OralDiet].dietType=NPO code |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Condition |</line>
  <line>|  |  | -name in spontaneous rupture of membranes VS |</line>
  <line>|  |  | -conditionstatus=Active |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfNonOccurrence with |</line>
  <line>|  |  | topic Condition |</line>
  <line>|  |  | -name in Pregnancy VS  |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfUknownOccurrence with  |</line>
  <line>|  |  | - topic Condition  |</line>
  <line>|  |  | -name in Rheumatic fever VS |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic DeviceUse |</line>
  <line>|  |  | -device.type in Holter monitor VS |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic DeviceUse |</line>
  <line>|  |  | -device.type=NTP |</line>
  <line>|  |  | modality Order |</line>
  <line>|  |  | -urgency=urgent |</line>
  <line>|  |  | StatementOfNonOccurrence with |</line>
  <line>|  |  | topic Procedure |</line>
  <line>|  |  | -procedureCode in cholecystectomy VS  |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Immunization |</line>
  <line>|  |  | -vaccine.vaccineType=hepatitis B vaccine |</line>
  <line>|  |  | -protocol={ |</line>
  <line>|  |  |   -doseTarget=hepatitis B |</line>
  <line>|  |  |   -doseSequence=1 |</line>
  <line>|  |  |   -seriesDoses=3 |</line>
  <line>|  |  | }  |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic MedicationTreatment |</line>
  <line>|  |  | -medication.code in Aspirin VS |</line>
  <line>|  |  | -dosage={ |</line>
  <line>|  |  |     -doseQuantity=81mg |</line>
  <line>|  |  |    -administrationSchedule=one per day |</line>
  <line>|  |  |    -route=oral |</line>
  <line>|  |  | }  |</line>
  <line>|  |  | modality Order |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Contraindication |</line>
  <line>|  |  | -contraindicatedAct = {Procedure with procedureCode in lumpectomy VS} |</line>
  <line>|  |  | -inference.inferredFrom = {Condition with name = PregnancyVS |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfNonOccurrence with |</line>
  <line>|  |  | topic FamilyHistory |</line>
  <line>|  |  | -condition in lung cancer VS |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Communication |</line>
  <line>|  |  | -medium=telephone |</line>
  <line>|  |  | -sender=provider |</line>
  <line>|  |  | -recipient=organization (SDDHS) |</line>
  <line>|  |  | -message= notification of pertussis case |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Communication |</line>
  <line>|  |  | -message=temperature above 104 F |</line>
  <line>|  |  | -recipient=attending |</line>
  <line>|  |  | -sender=nurse |</line>
  <line>|  |  | modality Order |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic AllergyIntolerance |</line>
  <line>|  |  | -sensitivityType=Allergy |</line>
  <line>|  |  | -stimulus=Penicillin |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic CareExperience |</line>
  <line>|  |  | -experience=poor response |</line>
  <line>|  |  | -about={StatementOfOccurrence about  first-line chemotherapy medications} |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic CareProgramParticipation |</line>
  <line>|  |  | -participationStatus=ongoing |</line>
  <line>|  |  | -programType=Government Guarantee Program for Immunization |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Goal  |</line>
  <line>|  |  | -goalFocus in HbA1c VS |</line>
  <line>|  |  | -goalValue=6.5% |</line>
  <line>|  |  | -goalPursuitEffectiveTime=3 months |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with  |</line>
  <line>|  |  | topic Goal  |</line>
  <line>|  |  | -goalFocus in LDL VS |</line>
  <line>|  |  | -goalValue=100 mg/dL  |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | Organization with |</line>
  <line>|  |  | -type=long-term care facility |</line>
  <line>|  |  | -characteristic={ |</line>
  <line>|  |  |   -code=ventilator |</line>
  <line>|  |  |   -presence=yes |</line>
  <line>|  |  | } |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Diet  |</line>
  <line>|  |  | -nutritionItem[OralDiet].dietType=increased fiber diet |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Diet  |</line>
  <line>|  |  | -nutritionItem[NutritionalSupplement].product= protein shake |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Diet  |</line>
  <line>|  |  | -nutritionItem[OralDiet].texture.textureType=easy to chew  |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Encounter |</line>
  <line>|  |  | -hospitalization.dischargeDisposition in Inpatient  hospice care VS |</line>
  <line>|  |  | -class=in-patient |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic CareProgramParticipation |</line>
  <line>|  |  | -programType=code for case-management program for HBV |</line>
  <line>|  |  | modality Proposal |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Condition |</line>
  <line>|  |  | -name in Cystic Fibrosis VS |</line>
  <line>|  |  | -conditionStatus=Inactive  |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | Patient with |</line>
  <line>|  |  | -isDeceased=yes |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic DeviceUse  |</line>
  <line>|  |  | -type in Pacemaker or Implantable defibrillator VS  |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Encounter |</line>
  <line>|  |  | -class=out-patient |</line>
  <line>|  |  | modality Order |</line>
  <line>|  |  | -indication.reason = Finding of hypertension |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Procedure |</line>
  <line>|  |  | -procedureCode in counseling for physical activity VS  |</line>
  <line>|  |  | modality Performance |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Condition |</line>
  <line>|  |  | -name in Migraine VS |</line>
  <line>|  |  | -conditionDetails={ |</line>
  <line>|  |  |    -name=triggering factor |</line>
  <line>|  |  |    -value=Bright Light |</line>
  <line>|  |  | }  |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | StatementOfOccurrence with |</line>
  <line>|  |  | topic Prediction |</line>
  <line>|  |  | -outcome=coronary heart disease |</line>
  <line>|  |  | -likelihood &gt; 20% |</line>
  <line>|  |  | -within 10 years |</line>
  <line>|  |  | -inference.inferenceMethod=Framingham Risk Score code |</line>
  <line>|  |  | modality Observation |</line>
  <line>|  |  | -observedAtTime during “Measurement Period” |</line>
</table>

