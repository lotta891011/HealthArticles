package com.example.healtharticles

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healtharticles.adapter.ArticleAdapter
import com.example.healtharticles.model.Article

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


//simple article fragment class, it creates '3D organs' tab
class OrgansArticlesFragment : Fragment(), ArticleAdapter.OnItemClickListener {
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
        val view: View = inflater.inflate(R.layout.fragment_organs_articles, container, false)
        val recyclerView= view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = context?.let { ArticleAdapter(initData(), it, this ) }
        container?.removeAllViews()
        return view
    }

    //private function containing articles that are being displayed
    private fun initData(): List<Article> {
        val itemList= ArrayList<Article>()
        itemList.add(Article(R.drawable.baner, getString(R.string.art1_title), "Powody, dla których medycyna potrzebuje druku 3D.\n" +
                "Z badań na temat rynku drukarek wynika, że branża medyczna stanowi 25% rynku druku 3D.\n" +
                "Zastosowanie drukarek znajduje miejsce w ortopedii, otolaryngologii, stomatologii jak i kardiologii,\n" +
                "Stało się tak m.in., dlatego ze technologie przyrostowe pozwalają na skrócenie czasu oraz obniżają koszty prototypowania i wdrożenia. \n" + "\n" +
                "Pierwszy wydruk na potrzeby medycyny wydrukowano w 1999 roku i posłużył on do szkieletu, który został pokryty komórkami własnymi chorego, i został on użyty do leczenia przerostu pęcherza moczowego, a trzy lata później naukowcy opracowali miniaturowa nerkę mająca zdolność do filtracji krwi i produkowania rozcieńczonego moczu u zwierząt. \n" +
                "Dzisiejsza technologia pozwala na drukowanie ubytków kości, tradycyjne protezy są zastępowane przez drukowane niestety i one posiadają wady. Należy unikać dużego obciążenia, ponieważ nie ta tak mocne i trwałe jak tradycyjne, należy też uważać gorących przedmiotów, które mogłyby uszkodzić strukturę protezy poprzesz stopienie tworzywa podatnego na działanie wysokich temperatur.\n" +
                "Protezy są drukowane najczęściej w kilku etapach a następnie złożone mimo wad sprawiają, że protezy stają się dostępne dla większego grona ludzi \n" + "\n" +
                "Najszerszym aspektem druku jest możliwość drukowania sztucznych narządów, jednak wyhodowanie tkanki ludzkiej w laboratorium jest skomplikowanym procesem drukarki 3D, których budulcem jest ludzka komórka dały nadzieje dla chorych oczekujących na transplantacje. Być może w przyszłości dzięki narządom drukowanym pacjent nie będzie już musiał czekać na dawce. \n" + "\n" +
                "W medycynie coraz częściej stawia się na personalizację wytwarzanych produktów, w szczególności implantów i modeli przedoperacyjnych. Tematyka wspomagania przedoperacyjnego jest relatywnie nowa, ze względu na znikomą ilość odpowiednich narzędzi do produkcji modeli pomocniczych. Do niedawna pomoc taka dotyczyła jedynie diagnostyki i analizy obrazowania medycznego .\n" + "\n" +
                "Przygotowanie spersonalizowanego modelu anatomicznego, musi uwzględniać specyficzny charakter danych będących źródłem informacji dla dalszych etapów produkcji. Obiekt wejściowy stanowi organizm ludzki, a dokładniej wybrany organ lub grupa narządów i struktur anatomicznych. Z powodu tego, że należy odwzorować już istniejący obiekt fizyczny, konieczne jest zastosowanie metod inżynierii odwrotnej, digitalizacji oraz segmentacji, które posłużą do uzyskania trójwymiarowego obrazu geometrycznego .\n" + "\n" +
                "Zaletą biodruku jest indywidualne podejście, potrzebne narządy lub ich fragmenty produkowane są z komórek własnych pacjenta, dzięki czemu nie ma ryzyka odrzucenia przeszczepu przez układ odpornościowy. Co najważniejsze, sztucznie stworzony narząd był w pełni kompatybilny z układem immunologicznym pacjenta. Oznacza to, że w przyszłości wydrukowane w ten sposób organy będą gotowe do przeszczepu. Rozwijanie technologii druku w pełni organicznych bionarządów, tworzonych po części z komórek macierzystych pobieranych od pacjenta zajmie nam jeszcze trochę czasu, który równie dobrze moglibyśmy poświęcić na udoskonalanie mechanicznych zamienników ludzkich narządów takich jak pompy insulinowe, czy też silikonowe serca. Metoda z wykorzystaniem komórek macierzystych będzie droższym i bardziej naturalnym zabiegiem. Właściwie wykorzystana technologia biodruku 3D to ogromna szansa dla nowoczesnej medycyny, obojętnie czy dla transplantologii czy farmacji.\n" + "\n"+
                "Źródła:" + "\n" +
                " - Tavares J. M., Jorge R. N.,: Developments in Medical Image Processing & Computational Vision, 2015\n" +
                " - Wyleżoł M., Muzalweska M., Metodologia modelowania w inżynierii biomedycznej z wykorzystaniem inżynierii rekonstrukcyjnej, „Mechanik” 2015, nr 02\n"))
        itemList.add(Article(R.drawable.baner, "Smartwatch dla zdrowia", "Dzięki inteligentnym zegarkom można dzisiaj nie tylko kontrolować godzinę odbierać połączenia czy sprawdzić wiadomość, ale są to świetne urządzenia, dzięki którym dbanie o zdrowie staje się dużo prostsze.\n" + "\n" +
                "W dzisiejszych czasach bezsenność stres i siedzący tryb życia powoduje negatywne skutki zdrowotne, dzięki zegarkom można kontrolować poziom stresu a w przypadku wysokiego poziomu stresu można zastosować ćwiczenia relaksacyjne, które pomogą nam go zredukować. Jednak jedna z najważniejszych funkcjonalności, jakie posiada smartwach to inteligentna analiza, jakości snu n podstawie pomiaru m.in. tętna spoczynkowego, oprócz tego zegarek pozwoli na kontrole godziny zaśnięcia oraz pobudki a podczas samego snu będzie monitorować fazy snu oraz przebudzenia.\n" + "\n" +
                "Dzięki zegarkom możemy również kontrolować saturacje krwi jest poziomem nasycenia krwi tlenem, który podaje się w procentach, pozwala nam to sprawdzić czy organizm jest odpowiednio natleniony.Co jest szczególnie pomocne u osób chorujących na choroby układu oddechowego. \n"))
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