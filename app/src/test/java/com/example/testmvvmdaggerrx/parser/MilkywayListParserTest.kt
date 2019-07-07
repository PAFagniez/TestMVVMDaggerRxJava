package com.example.testmvvmdaggerrx.parser

import android.net.Uri
import com.example.testmvvmdaggerrx.app.utils.DateUtils
import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import com.example.testmvvmdaggerrx.data.common.JSON
import com.example.testmvvmdaggerrx.data.parser.MilkywayImageListJsonParser
import com.example.testmvvmdaggerrx.utils.getJsonFromJsonFile
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class MilkywayListParserTest {

    private val milkywayListParser = MilkywayImageListJsonParser()
    lateinit var json: JSON
    lateinit var expectedImage1 : MilkywayImage
    lateinit var expectedImage2 : MilkywayImage

    @Before
    fun setUp(){
        expectedImage1 = MilkywayImage(
            "A monster in the Milky Way",
            "GSFC_20171208_Archive_e001362",
            "GSFC",
            "This image shows the star-studded center of the Milky Way towards the constellation of Sagittarius. The crowded center of our galaxy contains numerous complex and mysterious objects that are usually hidden at optical wavelengths by clouds of dust — but many are visible here in these infrared observations from Hubble.  However, the most famous cosmic object in this image still remains invisible: the monster at our galaxy’s heart called Sagittarius A*. Astronomers have observed stars spinning around this supermassive black hole (located right in the center of the image), and the black hole consuming clouds of dust as it affects its environment with its enormous gravitational pull.  Infrared observations can pierce through thick obscuring material to reveal information that is usually hidden to the optical observer. This is the best infrared image of this region ever taken with Hubble, and uses infrared archive data from Hubble’s Wide Field Camera 3, taken in September 2011.     Credit: NASA, ESA, and G. Brammer <b><a href=\"http://www.nasa.gov/audience/formedia/features/MP_Photo_Guidelines.html\" rel=\"nofollow\">NASA image use policy.</a></b>  <b><a href=\"http://www.nasa.gov/centers/goddard/home/index.html\" rel=\"nofollow\">NASA Goddard Space Flight Center</a></b> enables NASA’s mission through four scientific endeavors: Earth Science, Heliophysics, Solar System Exploration, and Astrophysics. Goddard plays a leading role in NASA’s accomplishments by contributing compelling scientific knowledge to advance the Agency’s mission.  <b>Follow us on <a href=\"http://twitter.com/NASA_GoddardPix\" rel=\"nofollow\">Twitter</a></b>  <b>Like us on <a href=\"http://www.facebook.com/pages/Greenbelt-MD/NASA-Goddard/395013845897?ref=tsd\" rel=\"nofollow\">Facebook</a></b>  <b>Find us on <a href=\"http://instagram.com/nasagoddard?vm=grid\" rel=\"nofollow\">Instagram</a></b>",
            DateUtils.getDateFromString("2017-12-08"),
            Uri.parse("https://images-assets.nasa.gov/image/GSFC_20171208_Archive_e001362/GSFC_20171208_Archive_e001362~thumb.jpg")
        )
        expectedImage2 = MilkywayImage(
            "Hubble Reveals Stellar Fireworks in ‘Skyrocket’ Galaxy",
            "GSFC_20171208_Archive_e000278",
            "GSFC",
            "Fireworks shows are not just confined to Earth’s skies. NASA’s Hubble Space Telescope has captured a spectacular fireworks display in a small, nearby galaxy, which resembles a July 4th skyrocket.  A firestorm of star birth is lighting up one end of the diminutive galaxy Kiso 5639. The dwarf galaxy is shaped like a flattened pancake, but because it is tilted edge-on, it resembles a skyrocket, with a brilliant blazing head and a long, star-studded tail.  Kiso 5639 is a rare, nearby example of elongated galaxies that occur in abundance at larger distances, where we observe the universe during earlier epochs. Astronomers suggest that the frenzied star birth is sparked by intergalactic gas raining on one end of the galaxy as it drifts through space.  “I think Kiso 5639 is a beautiful, up-close example of what must have been common long ago,” said lead researcher Debra Elmegreen of Vassar College, in Poughkeepsie, New York. “The current thinking is that galaxies in the early universe grow from accreting gas from the surrounding neighborhood. It’s a stage that galaxies, including our Milky Way, must go through as they are growing up.”  Observations of the early universe, such as Hubble’s Ultra-Deep Field, reveal that about 10 percent of all galaxies have these elongated shapes, and are collectively called “tadpoles.” But studies of the nearby universe have turned up only a few of these unusual galaxies, including Kiso 5639. The development of the nearby star-making tadpole galaxies, however, has lagged behind that of their peers, which have spent billions of years building themselves up into many of the spiral galaxies seen today.  Elmegreen used Hubble’s Wide Field Camera 3 to conduct a detailed imaging study of Kiso 5639. The images in different filters reveal information about an object by dissecting its light into its component colors. Hubble’s crisp resolution helped Elmegreen and her team analyze the giant star-forming clumps in Kiso 5639 and determine the masses and ages of the star clusters.  The international team of researchers selected Kiso 5639 from a spectroscopic survey of 10 nearby tadpole galaxies, observed with the Grand Canary Telescope in La Palma, Spain, by Jorge Sanchez Almeida and collaborators at the Instituto de Astrofisica de Canarias. The observations revealed that in most of those galaxies, including Kiso 5639, the gas composition is not uniform.  The bright gas in the galaxy’s head contains fewer heavier elements (collectively called “metals”), such as carbon and oxygen, than the rest of the galaxy. Stars consist mainly of hydrogen and helium, but cook up other “heavier” elements. When the stars die, they release their heavy elements and enrich the surrounding gas.  “The metallicity suggests that there has to be rather pure gas, composed mostly of hydrogen, coming into the star-forming part of the galaxy, because intergalactic space contains more pristine hydrogen-rich gas,” Elmegreen explained. “Otherwise, the starburst region should be as rich in heavy elements as the rest of the galaxy.”  Hubble offers a detailed view of the galaxy’s star-making frenzy. The telescope uncovered several dozen clusters of stars in the galaxy’s star-forming head, which spans 2,700 light-years across. These clusters have an average age of less than 1 million years and masses that are three to six times larger than those in the rest of the galaxy. Other star formation is taking place throughout the galaxy but on a much smaller scale. Star clusters in the rest of the galaxy are between several million to a few billion years old.  “There is much more star formation going on in the head than what you would expect in such a tiny galaxy,” said team member Bruce Elmegreen of IBM’s Thomas J. Watson’s Research Center, in Yorktown Heights, New York. “And we think the star formation is triggered by the ongoing accretion of metal-poor gas onto a part of an otherwise quiescent dwarf galaxy.”  Hubble also revealed giant holes peppered throughout the galaxy’s starburst head. These cavities give the galaxy’s head a Swiss-cheese appearance because numerous supernova detonations – like firework aerial bursts – have carved out holes of rarified superheated gas.  The galaxy, located 82 million light-years away, has taken billions of years to develop because it has been drifting through an isolated “desert” in the universe, devoid of much gas.  What triggered the starburst in such a backwater galaxy? Based on simulations by Daniel Ceverino of the Center for Astronomy at Heidelberg University in Germany, and other team members, the observations suggest that less than 1 million years ago, Kiso 5639’s leading edge encountered a filament of gas. The filament dropped a large clump of matter onto the galaxy, stoking the vigorous star birth.  Debra Elmegreen expects that in the future other parts of the galaxy will join in the star-making fireworks show. “Galaxies rotate, and as Kiso 5639 continues to spin, another part of the galaxy may receive an infusion of new gas from this filament, instigating another round of star birth,” she said.  The team’s results have been accepted for publication in The Astrophysical Journal.  Other team members include Casiana Munoz-Tunon and Mercedes Filho (Instituto de Astrofísica de Canarias, Canary Islands), Jairo Mendez-Abreu (University of St. Andrews, United Kingdom), John Gallagher (University of Wisconsin-Madison), and Marc Rafelski (NASA's Goddard Space Flight Center, Greenbelt, Maryland).  The Hubble Space Telescope is a project of international cooperation between NASA and the European Space Agency. NASA's Goddard Space Flight Center in Greenbelt, Maryland, manages the telescope. The Space Telescope Science Institute (STScI) in Baltimore, Maryland, conducts Hubble science operations. STScI is operated for NASA by the Association of Universities for Research in Astronomy in Washington, D.C.  For images and more information about Kiso 5639 and Hubble, visit:   <a href=\"http://hubblesite.org/news/2016/23\" rel=\"nofollow\">hubblesite.org/news/2016/23</a>  <a href=\"http://www.nasa.gov/hubble\" rel=\"nofollow\">www.nasa.gov/hubble</a>  Image credit: NASA, ESA, and D. Elmegreen (Vassar College)  <b><a href=\"http://www.nasa.gov/audience/formedia/features/MP_Photo_Guidelines.html\" rel=\"nofollow\">NASA image use policy.</a></b>  <b><a href=\"http://www.nasa.gov/centers/goddard/home/index.html\" rel=\"nofollow\">NASA Goddard Space Flight Center</a></b> enables NASA’s mission through four scientific endeavors: Earth Science, Heliophysics, Solar System Exploration, and Astrophysics. Goddard plays a leading role in NASA’s accomplishments by contributing compelling scientific knowledge to advance the Agency’s mission.  <b>Follow us on <a href=\"http://twitter.com/NASAGoddardPix\" rel=\"nofollow\">Twitter</a></b>  <b>Like us on <a href=\"http://www.facebook.com/pages/Greenbelt-MD/NASA-Goddard/395013845897?ref=tsd\" rel=\"nofollow\">Facebook</a></b>  <b>Find us on <a href=\"http://instagrid.me/nasagoddard/?vm=grid\" rel=\"nofollow\">Instagram</a></b>      ",
            DateUtils.getDateFromString("2017-12-08"),
            Uri.parse("https://images-assets.nasa.gov/image/GSFC_20171208_Archive_e000278/GSFC_20171208_Archive_e000278~thumb.jpg")
        )
        json = getJsonFromJsonFile("MilkywayListJson")
    }

    @Test
    @Throws(Exception::class)
    fun testMilkywayImageListParsingFromValidJson() {
        val milkywayImageList = milkywayListParser.parse(json)

        val actualImage1 = milkywayImageList[0]
        val actualImage2 = milkywayImageList[1]

        assertEquals("First images is invalid", expectedImage1, actualImage1)
        assertEquals("Second images is invalid", expectedImage2, actualImage2)
    }


}