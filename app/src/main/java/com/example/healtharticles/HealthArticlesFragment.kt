package com.example.healtharticles

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healtharticles.adapter.ArticleAdapter
import com.example.healtharticles.model.Article

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//simple article fragment class, it creates 'health' tab
class HealthArticlesFragment : Fragment() ,ArticleAdapter.OnItemClickListener{
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var intent : Intent

    //parameters aren't used
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflating the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_health_articles, container, false)
        val recyclerView= view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = context?.let { ArticleAdapter(initData(), it, this )}
        container?.removeAllViews()
        return view
    }

    //private function containing articles that are being displayed
    private fun initData(): List<Article> {
        val itemList= ArrayList<Article>()
        itemList.add(Article(R.drawable.baner, "Zawał serca", "Zawał serca najczęściej objawia się silnym, rozlanym bólem i pieczeniem lub uciskiem w okolicy mostka. Ból może promieniować do żuchwy, szyi, pleców, rąk lub barku. Niekiedy zawał objawia się bólem brzucha, nudnościami, wymiotami lub zasłabnięciem. Często dolegliwościom tym towarzyszą zimne poty, duszność, zawroty głowy, uczucie drętwienia, kołatania serca oraz silny lęk. U około 70% chorych z ostrym zawałem dochodzi do wytworzenia blizny pozawałowej – tkanka nie kurczy się, a serce ulega osłabieniu. Do innych konsekwencji zawału należą niewydolność krążenia przejawiająca się dusznością, obrzękami kończyn dolnych i pogorszeniem tolerancji na wysiłek oraz zaburzeniami rytmu serca, które mogą być groźne dla życia.\n" + "\n" +
                "Od około 60 lat w piśmiennictwie występuje pojęcie „zawału serca bez istotnych zwężeń w tętnicach wieńcowych”. Zjawisko to jest opisywane u 1–12% pacjentów, u których z powodu zawału serca wykonano badanie angiograficzne tętnic wieńcowych .\n" +"\n" +
                "Ruch leczy serce, czyli aktywność fizyczna po zawale:\n" +
                "Systematyczna aktywność fizyczna stanowi jeden z najlepszych leków, jakie istnieją w kardiologii. Serce to mięsień, dlatego ruch jest niezbędny do utrzymania go we właściwej kondycji. Aktywność fizyczna po zawale ma na celu wytrenowanie mięśnia sercowego, poprawę kondycji zarówno fizycznej, jak i psychicznej. Powinna być ona odpowiednio dobrana dawkowana, dostosowana do aktualnego stanu układu sercowo-naczyniowego. Przez pierwszy miesiąc od wystąpienia incydentu kardiologicznego powinno się prowadzić raczej oszczędzający tryb życia.\n" + "\n" +
                "Jest bardzo ważne, aby przekonać pacjenta o braku przeciwwskazań do prowadzenia przez niego normalnego trybu życia .\n" + "\n" +
                "Pamiętaj! Najmniejsza nawet aktywność fizyczna jest lepsza niż żadna.\n" + "\n" +
                "Dla pacjentów kardiologicznych zalecana jest regularna aktywność fizyczna o umiarkowanym natężeniu stosowana 4-6 razy w tygodniu, przez co najmniej 30 minut. Ćwiczenia można wykonywać wielokrotnie w ciągu dnia w cyklach 5-20 minutowych.\n"))
        itemList.add(Article(R.drawable.baner, "Porady o zdrowym treningu", "Zachowania sprzyjające zwiększeniu ogólnej aktywności oraz kondycji fizycznej:\n" + "\n" +
                "• wybieranie schodów zamiast windy,\n" +
                "• niekorzystanie z samochodu, jeśli to możliwe i niekonieczne,\n" +
                "• parkowanie samochodu dalej niż miejsce docelowe,\n" +
                "• zwiększenie częstotliwości spacerów i pieszych wycieczek,\n" +
                "• spotkania towarzyskie połączone z aktywnością (np. siłownia na świeżym powietrzu, nordic walking, przejażdżka rowerowa, wspólny spacer, itp.).\n" +
                "\n" + "\n" +
                "Korzyści wynikające ze stosowania regularnej, umiarkowanej aktywności fizycznej:\n" + "\n" +
                "• poprawa wydolności fizycznej, kondycji i tolerancji na wysiłek w każdym wieku,\n" +
                "• spowolnienie spoczynkowej i wysiłkowej czynności serca oraz normalizacja ciśnienia krwi,\n" +
                "• zwiększenie ukrwienia serca i rozwój krążenia obocznego,\n" +
                "• poprawa funkcji płuc, wzmocnienie mięśni oddechowych,\n" +
                "• redukcja i kontrola masy ciała,\n" +
                "• zmniejszenie ryzyka odkładania się blaszki miażdżycowej\n" +
                "i powstawania zakrzepów,\n" +
                "\n"))
        itemList.add(Article(R.drawable.baner, "Zasady bezpiecznego treningu", "• bądź zmotywowany i systematyczny aktywność fizyczna o umiarkowanej intensywności pozwala na wytrenowanie serca oraz obniżenie wartości ciśnienia krwi i tętna,\n" + "\n" +
                "• nie stosuj wysiłków maksymalnych,\n" + "\n" +
                "• dostosuj intensywność ćwiczeń do swoich możliwości,jeśli masz objawy infekcji – zrezygnuj z treningu,\n" + "\n" +
                "• jeśli przed rozpoczęciem treningu Twoje tętno jest > 100/minutę, a ciśnienie > 160/100 zrezygnuj z treningu,\n" +"\n" +
                "• nie przekraczaj wartości tętna treningowego (HRt) podczas ćwiczeń,\n" +"\n" +
                "• zwiększaj czas i intensywność wysiłku stopniowo, gdy nie odczuwasz zmęczenia lub gdy tętno nie wzrasta,\n" +"\n" +
                "• pamiętaj o prawidłowym oddechu w trakcie wykonywania ćwiczeń (wdech nosem, wydech ustami),\n" +"\n" +
                "• dbaj o nawodnienie organizmu przed, w trakcie i po treningu,\n" +"\n" +
                "• treningi o większej intensywności wykonuj w krótszym czasie – max. 30 minut, natomiast treningi o mniejszej intensywności mogą trwać dłużej – od 30 do max. 60 minut,\n" +"\n" +
                "• unikaj ćwiczeń w pochyleniu, ćwiczeń na bezdechu, wymagających dużego wysiłku w krótkim czasie,\n" +"\n" +
                "• zawsze przerwij ćwiczenia, gdy poczujesz ból w klatce piersiowej, ucisk, pieczenie lub kołatanie serca, brak oddechu, zawroty głowy, osłabienie lub pogorszenie tolerancji wysiłku,\n" + "\n" +
                "• nie podejmuj aktywności na, zewnątrz, gdy jest silny wiatr, duży mróz i gołoledź oraz unikaj ćwiczeń w wysokiej temperaturze, nasłonecznieniu i dużej wilgotności oraz gdy jest wysokie zapylenie lub smog – wówczas wykonaj swój trening w domu\n" + "\n" +
                "• sprzęt do ćwiczeń dobieraj stosownie do swoich umiejętności i możliwości\n"))
        itemList.add(Article(R.drawable.baner, "Profilaktyka chorób serca", "Najważniejsze zasady profilaktyki i leczenia chorób serca:\n" +
                "• przyjmuj leki zawsze zgodnie z zaleceniami lekarza,\n" +
                "• pamiętaj o regularnej aktywności fizycznej,\n" +
                "• rzuć palenie,\n" +
                "• kontroluj ciśnienie krwi i tętno,\n" +
                "• kontroluj poziom cukru we krwi,\n" +
                "• kontroluj poziom cholesterolu i trójglicerydów (LDL, HDL, TG) – nie przerywaj leczenia statynami po osiągnięciu zalecanych poziomów,\n" +
                "• zmień nawyki żywieniowe – stosuj dietę lekkostrawną z dużą ilością warzyw i owoców,\n" +
                "• pamiętaj o odpowiedniej ilości płynów w diecie i podczas aktywności fizycznej,\n" +
                "• walcz ze stresem dnia codziennego.\n" + "\n" +
                "Mimo prób poznania czynnika etiologicznego zawału serca u pacjentów bez istotnych zmian w tętnicach wieńcowych, udaje się to tylko u 1/3 pacjentów .\n" + "\n" +
                "Leki:\n" +
                "Po zawale leki powinny być przyjmowane systematycznie, o tej samej porze i zawsze zgodnie z zaleceniami lekarza. Niewskazane jest przerywanie stosowania leków, tłumacząc się dobrym samopoczuciem.\n" + "\n" +
                "Pamiętaj! Nigdy samodzielnie nie odstawiaj leków i nie modyfikuj ich dawek!\n" +
                "Jakiekolwiek zmiany w leczeniu muszą być konsultowane z lekarzem!\n" +
                "Pacjent po zawale powinien zawsze posiadać spis aktualnie stosowanych leków i ich dawek. Ma to szczególne znaczenie w sytuacjach nagłych, np. interwencji pogotowia ratunkowego lub podczas wizyty u lekarza i modyfikacji leczenia.\n" + "\n" +
                "\n" + "\n" +
                "Ruch + farmakologia + zdrowa dieta = zdrowe serce\n"))
        itemList.add(Article(R.drawable.baner, "Nadciśnienie i jego objawy", "Nadciśnienie tętnicze jest jednym z kluczowych czynników ryzyka chorób układu sercowo-naczyniowego, zalicza się do chorób cywilizacyjnych.  Według wyników badania WOBASZ w Polsce na nadciśnienie tętnicze cierpi 42,1% mężczyzn i 32,9% kobiet. Czynnikami zwiększającymi ryzyko rozwoju nadciśnienia tętniczego są palenie tytoniu, nadmierne spożycie alkoholu, nadmierne spożycie soli i tłuszczów nasyconych, niskie spożycie magnezu, wapnia i potasu, mała aktywność fizyczna oraz otyłość. \n" + "\n" +
                "Do krajów, w których przypadki nadciśnienia tętniczego stanowią duży odsetek, zalicza się głównie kraje wysoko uprzemysłowione, takie jak: Kanada, Stany Zjednoczone, Australia, kraje Europejskie, Japonia (25–50%) . \n" + "\n" +
                "Objawy występujące przy nadciśnieniu: \n" +
                "•\tUczucie duszności,\n" +
                "•\tBóle i zawroty głowy,\n" +
                "•\tBezsenność,\n" +
                "•\tUczucie kołatania serca,\n" +
                "•\tUderzenia gorąca,\n" +
                "•\tZaczerwienienie twarzy,\n" +
                "•\tPotliwość.\n" +
                "\n"))
        itemList.add(Article(R.drawable.baner, "Dieta przy nadciśnieniu", "Spożycie nadmiaru sodu- powszechnie stosowana sól kuchenna zawiera chlorek sodu (NaCl), który — przyjmowany w nadmiernej ilości — może się przyczyniać do rozwoju nadciśnienia tętniczego.\n" + "\n" +
                "Zaleca się spożycie soli do 6 g dziennie, co stanowi 2,4 g sodu.\n" +
                "Niskie spożycie potasu - głównymi funkcjami tego pierwiastka są utrzymanie ciśnienia osmotycznego, udział w utrzymaniu równowagi kwasowo-zasadowej oraz udział w procesach związanych z kurczliwością mięśni. Ilość K dostarczanego z pożywieniem wynosi 1–4 g, tj. 25–100 mmol/dobę. Niedobór tego pierwiastka w diecie może prowadzić do hipokaliemii, czyli stanu, w którym stężenie K w osoczu jest niższe niż 3,8 mmol/. \n" + "\n" +
                "Niska podaż wapnia- Ca jest pierwiastkiem stanowiącym 1,4–1,6% masy ciała człowieka i stanowi 1,0–1,2 kg. Około 99% Ca znajduje się w tkance kostnej, a zaledwie 1% — w płynie pozakomórkowym. Prawidłowe stężenie wapnia w surowicy wynosi od 2,2 do 2,6 mmol/. Wapń wchłania się w przewodzie pokarmowym, średnio w ilości 30–40% z przyjętego pożywienia. Niewchłonięta część jest wydalona z kałem (80%), natomiast pozostały wapń zostaje wydalony z moczem (20%). Ze względu na szeroki zakres działania wapnia, między innymi na skurcz mięśni gładkich naczyń, jest to pierwiastek, którego niedobór w diecie może się przyczyniać do wzrostu ryzyka wystąpienia nadciśnienia.\n" + "\n" +
                "Zbyt mała aktywność fizyczna stanowi ważny czynnik ryzyka nadciśnienia tętniczego, między innymi z powodu zwiększonej predyspozycji u tych osób do nadwagi i otyłości. Jednak, ze względu na negatywne działanie SFA na układ sercowo-naczyniowy, u osób z nadciśnieniem zaleca się nie więcej niż 7% energii z tłuszczu . Poza tym siedzący tryb życia prowadzi do zwiększonej spoczynkowej stymulacji adrenergicznej układu współczulnego, co ma związek ze wzrostem ciśnienia tętniczego.\n" + "\n" +
                " Nadmierne spożycie alkoholu stanowi istotny czynnik ryzyka nadciśnienia tętniczego. Ma to ścisły związek z działaniem nadmiaru etanolu na układ krwionośny. Po przekroczeniu tak zwanego progu presyjnego rozkurczowe ciśnienie tętnicze może się zwiększyć o 1–2 mm Hg, a SBP — o 3–4 mm Hg. Próg presyjny wiąże się ze spożyciem 10–20 g czystego etanolu w przypadku kobiet i 20–30 g w przypadku mężczyzn. \n" + "\n" +
                "\n" +
                "Wzrost ciśnienia następuje natychmiast po zapaleniu papierosa i utrzymuje się przez około pół godziny. Interesujący jest tak zwany efekt spłaszczenia tego zjawiska u nałogowych palaczy, jednak i tak zauważa się wzrost średniego ciśnienia. W przypadku ciśnienia określanego mianem prawidłowego, wartości skurczowe ciśnienia powinny wynosić 120-129 mmHg, a rozkurczowego 80-84 mmHg. Interesujący jest tak zwany efekt spłaszczenia tego zjawiska u nałogowych palaczy, jednak i tak zauważa się wzrost średniego ciśnienia .\n" + "\n" +
                " Radzenia sobie ze stresem- stres stymuluje nas do działania, poprzez wydzielane hormony: adrenalinę i hormony kory nadnerczy. Hormony te działają na układ krążenia, przyspieszając rytm serca, podnosząc ciśnienie krwi i zwężając naczynia krwionośne. Im więcej stresów przeżywamy, tym bardziej nasze serce i naczynia są obciążone. \n" + "\n" +
                "Kontrola ciśnienia krwi- utrzymujące się podwyższone ciśnienie krwi prowadzi do zwężenia tętnic i rozwoju blaszek miażdżycowych. Ważne jest jak najwcześniejsze wykrywanie nadciśnienia tętniczego i jego leczenie. Najlepiej jest mierzyć ciśnienie krwi rutynowo podczas wizyty u lekarza.\n" + "\n" +
                "U wielu chorych nadciśnienie tętnicze przebiega bezobjawowo nawet przez kilka lat. Niestety nieleczone może raptem objawić się niewydolnością nerek, zawałem czy udarem. Dlatego tak ważne jest, by kontrolować ciśnienie, a w przypadku nieprawidłowości jak najszybciej podjąć leczenie. \n"))
        itemList.add(Article(R.drawable.baner, "Cukrzyca - objawy i diagnostyka", "Cukrzyca jest to przewlekła choroba, w której trzustka nie produkuje wystarczającej ilości insuliny lub produkowana insulina nie jest prawidłowo wykorzystywana przez komórki ciała człowieka. Na świecie cukrzyca dotyka 463 miliony ludzi - z czego prawie 50 proc. nie wie o swojej chorobie.\n" + "\n" +
                "Objawy: \n" +
                "•\tZmęczenie,\n" +
                "•\tOsłabienie,\n" +
                "•\tWielomocz,\n" +
                "•\tZwiększone pragnienie,\n" +
                "•\tNadmierny apetyt,\n" +
                "•\tChudnięcie,\n" + "\n" +
                "Diagnostyka: \n" +
                "Bez względu na wiek badanie glikemii ( poziomu cukru we krwi) należy przeprowadzać u osób z następujących grup ryzyka:\n" +
                "•\tZ nadwagą, – jeżeli cukrzyca występuje rodzinnie,\n" +
                "•\tMało aktywnych fizycznie, – jeżeli w poprzednim badaniu glikemia była powyżej 100 mg/dl,\n" +
                "•\tKobiety, które urodziły dziecko o masie ciała powyżej 4 kg lub miały stwierdzoną cukrzycę ciężarnych,\n" +
                "•\tKobiety z zespołem policystycznych jajników,\n" +
                "•\tZ nadciśnieniem tętniczym, hiperlipidemią \n" + "\n" +
                "W Polsce obecnie na cukrzycę choruje\n" +
                "2,3 mln osób, a wskaźnik chorobowości szacuje się na\n" +
                "poziomie 7,6% .\n" + "\n" +
                "KLASYFIKACJA CUKRZYCY\n" +
                "Cukrzyca typu 1 – charakteryzuje się bezwzględnym niedoborem insuliny, występuje u osób młodszych, najczęściej u dzieci i młodzieży, zwykle zaczyna się nagle, a w leczeniu jedyną metodą jest zastosowanie insuliny.\n" + "\n" +
                "Cukrzyca typu 2 – jest najczęściej występującą formą tej choroby, dotyczy 90% wszystkich chorych, zwykle rozwija się u osób po 40 roku życia, otyłych, u których w rodzinie ktoś chorował na cukrzycę, początkowo przebiega bezobjawowo. W leczeniu stosuje się ograniczenia dietetyczne, wysiłek fizyczny, następnie doustne leki przeciwcukrzycowe. Zwykle po kilku latach trwania choroby konieczne jest zastosowanie insuliny.\n" + "\n" +
                "Powodem do obaw jest również to, że cukrzycę rozpoznaje się w coraz młodszym wieku, nawet u dzieci i młodzieży .\n" + "\n" +
                "Specyficzne rodzaje cukrzycy o różnej etiologii: defekty genetyczne, choroby trzustki, schorzenia endokrynologiczne.\n" + "\n" +
                "Prawidłowy poziom cukru na czczo w osoczu krwi żylnej wynosi 60-99mg/dl.\n" + "\n" +
                "Uważa się, że nawet 60–67% chorych na cukrzycę, według różnych źródeł umiera z powodu złego wyrównania lub braku leczenia choroby prowadzących do wielu powikłań makro- i mikronaczyniowych . \n"))
        itemList.add(Article(R.drawable.baner, "Leczenie cukrzycy", "•\tModyfikacja stylu życia,\n" +
                "•\tWdrożenie zasad zdrowego odżywiania,\n" +
                "•\tLeczniczy wysiłek fizyczny,\n" +
                "•\tSamokontrola,\n" +
                "•\tSystematyczna kontrola lekarska,\n" +
                "•\tFarmakoterapia (leki doustne lub insulina).\n" + "\n" +
                "Celem leczenia chorych na cukrzycę jest zapobieganie powikłaniom i zapewnienie poprawy, jakości życia. Aby do tego doszło należy dążyć do wyrównania glikemii, skutecznie leczyć nadciśnienie tętnicze i zaburzenia lipidowe, które zwykle towarzyszą cukrzycy. Ważna jest również edukacja pacjenta w zakresie samokontroli, odżywiania i aktywności fizycznej. Chorzy leczeni insuliną muszą opanować zasady podawania insuliny. \n" +
                "\n" +
                "Źle kontrolowana cukrzyca jest chorobą progresywną, która może prowadzić do niepełnosprawności, a w konsekwencji nawet do przedwczesnej śmierci .\n" +
                "\n" +
                "Zalecane postępowania dla pacjentów z cukrzycą: \n" +
                "•\tJedz regularnie i unikaj głodówek.\n" +
                "•\tWybieraj produkty o niskim indeksie glikemicznym (IG < 55). \n" +
                "•\tOgranicz alkohol. \n" +
                "•\tUnikaj dosalania posiłków. \n" +
                "•\tWybieraj zdrowe tłuszcze. \n" +
                "•\tJedz zbilansowane posiłki. \n" +
                "•\tPamiętaj o piciu wody.\n"))
        itemList.add(Article(R.drawable.baner, "Źródła", " - Alpert J.S. Fascination with myocardial infarction and normal coronary arteries. Eur. Heart J. 2001; 22: 1364–1366.\n" +
                " - Alpert J.S. Myocardial infarction with angiographically normal coronary arteries. Arch. Intern. Med. 1994; 154: 265–269.\n" +
                " - Da Costa A., Isaaz K., Faure E., Mourot S., Cerisier A., Lamaud M. Clinical characteristics, aetiological factors and long-term prognosis of myocardial infarction with an absolutely normal coronary angiogram; a 3 year follow-up study in 91 patients. Eur. Heart J. 2001; 22: 1459–1465.\n  " +
                " - Jarosz M., Respondek W. Nadciśnienie tętnicze, porady lekarzy i dietetyków. Wydawnictwo Lekarskie PZWL, Warszawa 2006.\n" +
                " - Kozłowska-Wojciechowska M. Czynniki żywieniowe w profilaktyce i leczeniu nadciśnienia tętniczego. Terapia 2005; 7–8: 17–22\n" +
                " - Szczęch R., Hering D., Szyndler A., Narkiewicz K. Nadciśnienie tętnicze a palenie papierosów. Terapia 2004; 7–8: 12–15.\n" +
                " - Getrig H., Przysławski J. Bromatologia. Wydawnictwo Lekarskie PZWL, Warszawa 2007.\n " +
                " - Piątkiewicz P. Cukrzyca. Aspekty prawne i społeczne. Via Medica, Gdańsk 2016.\n" +
                " - Małecki M, Skupień J. Problemy diagnostyki różnicowej typów cukrzycy. Pol Arch Med Wewn. 2008; 118(7–8): 435–440.\n" +
                " - International Diabetes Federation. Diabetes Atlas 7th edition. IDF, Bruksela 2015.\n" +
                " - Małgorzata Kołpa, Aneta Grochowska, Barbara Kubik, Katarzyna Stradomska, Państwowa Wyższa Szkoła Zawodowa w Tarnowie, 'Styl życia i wyrównanie metaboliczne u pacjentów z cukrzycą typu 2 a ryzyko powikłań przewlekłych tej choroby'.\n"))
        return itemList
    }

    //function creating action on click of the article preview
    override fun onItemClick(position: Int) {
        val clickedItem: Article = initData()[position]
        intent = Intent(context, ArticleActivity::class.java)
        intent.putExtra("image",clickedItem.imageResourceId)
        intent.putExtra("title",clickedItem.title)
        intent.putExtra("content",clickedItem.content)
        startActivity(intent)
    }
}