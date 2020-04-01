-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- CREATE TABLE "Albums" ---------------------------------------
CREATE TABLE `Albums`( 
	`AlbumID` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`Artist` Int( 0 ) NULL,
	`Name` VarChar( 100 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
	`Year` Int( 0 ) NULL,
	`RecordLabel` VarChar( 100 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
	PRIMARY KEY ( `AlbumID` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 5;
-- -------------------------------------------------------------


-- CREATE TABLE "Artists" --------------------------------------
CREATE TABLE `Artists`( 
	`ArtistID` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`Nationality` VarChar( 50 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
	`Name` VarChar( 50 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
	PRIMARY KEY ( `ArtistID` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 5;
-- -------------------------------------------------------------


-- CREATE TABLE "Songs" ----------------------------------------
CREATE TABLE `Songs`( 
	`SongID` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`Length` Int( 0 ) NULL,
	`Lyrics` Text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
	`Year` Int( 0 ) NULL,
	`Name` VarChar( 200 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
	`Album` Int( 0 ) NULL,
	PRIMARY KEY ( `SongID` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 8;
-- -------------------------------------------------------------


-- Dump data of "Albums" -----------------------------------
INSERT INTO `Albums`(`AlbumID`,`Artist`,`Name`,`Year`,`RecordLabel`) VALUES 
( '3', '2', 'Dont smile at me', '2017', 'Interscope' ),
( '4', '4', 'New Songs', '2005', 'Yeni Yapim' ),
( '5', '5', 'El Dorado', '2017', 'Sonny' ),
( '6', '5', 'She Wolf', '2009', 'Epic' ),
( '7', '7', 'Red', '2012', 'Big Machine' ),
( '8', '7', 'Reputation', '2017', 'Big Machine' ),
( '9', '6', 'The Bright Side', '2015', 'Sony' );
-- ---------------------------------------------------------


-- Dump data of "Artists" ----------------------------------
INSERT INTO `Artists`(`ArtistID`,`Nationality`,`Name`) VALUES 
( '2', 'US', 'Billie Eilish' ),
( '3', 'GB', 'The beatles' ),
( '4', 'TR', 'Vera' ),
( '5', 'CO', 'Shakira' ),
( '6', 'AU', 'Lenka' ),
( '7', 'US', 'Taylor Swift' );
-- ---------------------------------------------------------


-- Dump data of "Songs" ------------------------------------
INSERT INTO `Songs`(`SongID`,`Length`,`Lyrics`,`Year`,`Name`,`Album`) VALUES 
( '4', '250', 'rsonality  We hear the honest confessions of a teenager who has known heartbreak  self loathing and love  Don t Smile at Me is dreamy and depressing  enchanting and haunting  And it warrants both praise and caution  8  Nicole Almeida of Atwood Magazine said  Sixteen year old Billie Eilish s debut EP title warns you  Don t Smile at Me  It s a direct order  a powerful declaration  a statement coming from the mouth of someone who knows who she is  what she likes and doesn t like  and who won t play by anyone el', '2017', 'Watch', '3' ),
( '5', '500', 'Hello there Yall this is great', '2003', 'Suprise', '4' ),
( '6', '300', 'Gelme Dedi YOYOYo', '2010', 'Gelme Dedi', '4' ),
( '7', '450', 'He Bad BOIIIIIIIIII', '2020', 'Bad Man', '3' ),
( '8', '190', 'Voy caminando sobre un mar de hojas secas Vuelan los  ngeles sobre Berl n Van entonando junto a m  un aleluya Mientras la lluvia cae dentro de m Extra o tu voz Estoy en tierra de nadie  me falta hasta el aire De espaldas al sol Pasa otro d a sin tiNo sirve de nada llegar a n m s lejos Ni toda la fama  ni todo el dinero No sirve de nada si no est s conmigo Y la soledad se me clava en los huesosNo sirve de na ah ah  nada Na ah ah  nada ah ah Na a da  na ah  na a da No  no  no  no', '2017', 'Nada', '5' ),
( '9', '201', ' Letra de  Trap  ft  Maluma    Intro  Shakira  Quiere que lo hagamo  en diferentes partes Pero estoy cansada de desilusiones Hace mucho tiempo no creo en los hombres Y no necesito de este mal de amores   Verso 1  Maluma  Me pide y yo le doy Sabe que siempre aqu  estoy Casi siempre llama tarde y nunca cambia al Dirty Boy Quiero besarte  satisfacerte Oye  baby  no me niegues  v monos   Coro  Maluma   Shakira  Quiere que se lo haga en diferentes partes Ella est  cansada de desilusiones No quiere saber de un rompe corazones Ll mame cuando quiera   beba Quiere que lo hagamo  en diferentes partes Pero estoy cansada de desilusiones No quiero saber de un rompe corazones Ll mame cuando quiera   beba   Verso 2  Maluma  Maluma   Shakira  Tu mu vete encima  e m  Compl ceme  ay  beb  Tu mu vete encima  e m  Compl ceme Cuando t  quieras Baby  v monos  perd monos De la realidad escap monos En la cama t  y yo mat monos Con eso que naciste  d melo   Coro  Maluma  Maluma   Shakira  Quiere que se lo haga en diferentes partes Ella est  cansada de desilusiones No quiere saber de un rompe corazones Ll mame cuando quiera   beba Quiere que se lo haga en diferentes partes Ella est  cansada de desilusiones No quiere saber de un rompe corazones Ll mame cuando quiera   beba   Verso 3  Shakira   Maluma  Ambos  Dale una prueba  ponle Nutella T  solo disfruta que las horas vuelan Vuelan  vuelan  vuelan  ah  Haci ndolo  Inolvidable aventura  35 mil pies de altura A velocidad crucero pude ver como te desnudas No espero menos de ti Me gusta hacerte sentir Y si firmo el contrato  contigo quiero repetir   Interludio Instrumental  Shakira  Ah  ah  ah  ah  ah Ah Ah  ah  ah  ah  ah Ah   Coro  Maluma   Shakira  Ambos  Quiere que se lo haga en diferentes partes Pero estoy cansada de desilusiones No quiero saber de un rompe corazones Ll mame cuando quiera   beba Quiere que se lo haga en diferentes partes Ella est  cansada de desilusiones No quiere saber de un rompe corazones Ll mame cuando quiera   beba', '2018', 'Tap', '5' ),
( '10', '189', ' Letra de  Loba     Introducci n  Sigilosa al pasar Sigilosa al pasar Esa loba es especial Mirala  caminar  caminar   Verso 1  Qui n no ha querido a una diosa lic ntropa En el ardor de una noche rom ntica Mis aullidos son el llamado Yo quiero un lobo domesticado   Pre Coro  Por fin he encontrado un remedio infalible Que borre del todo la culpa No pienso quedarme a tu lado mirando la tele Y oyendo disculpas La vida me ha dado un hambre voraz Y t  apenas me das caramelos  Ah  Me voy con mis piernas y mi juventud por ah  Aunque te maten los celos   Coro  Una loba en el armario Tiene ganas de salir  Ah ooh  Deja que se coma el barrio Antes de irte a dormir   Verso 2  Tengo tacones de aguja magn tica Para dejar la manada fren tica La luna llena como una fruta No da consejos  ni los escucha   Pre Coro  Llevo conmigo un radar especial para localizar solteros Si acaso me meto en aprietos tambi n Llevo el n mero de los bomberos Ni tipos muy lindos ni divos ni ni os ricos yo s  lo que quiero  Ay  Pasarla muy bien y portarme muy mal En los brazos de alg n caballero   Coro  Una loba en el armario Tiene ganas de salir  Ah ooh  Deja que se coma el barrio Antes de irte a dormir   Puente 1  Cuando son casi la una la loba en celo saluda a la luna Duda si andar por la calle o entrar en un bar a probar fortuna Ya est  sentada en su mesa y pone la mira en su pr xima presa Pobre del desprevenido que no se esperaba una de esas   Puente 2  Sigilosa al pasar Sigilosa al pasar Esa loba es especial Mirala  caminar  caminar   Outro  Deja que se coma el barrio Antes de irte a dormir', '2009', 'Loba', '6' ),
( '11', '193', ' Did It Again   First Floor  ah    Room Sixteen  ah    Smells like danger  let s go  Even better  let s go  Set your goals  ah    Bless our souls  ah    I m in trouble  yes  I know  But it feels like heaven  HEY   You were like one of those guys The kind with a wandering eyes  HEY   But I said   hey what the hell  once in my life I ll take a ride on the wild side  You were so full of yourself But damn  were you cute  as well  HEY   You liked my legs  I liked your moves Anyone could tell that it s hard to deny that  Did it again  now I got it all wrong But it felt so right I can t believe it  And all the mistakes That went on for too long Wish there was a way I could delete it  Eh  Eh  Eh  Eh Ah  ah  ah  ah  Second night in a row Back in trouble I don t get it Gotta keep it down  Cause the lobby called We ignore it  yes  I know  Getting better  Hey   When it comes to men it s known That I end up choosing wrong  Cause I always trip and fall The same old rock and repeat and go back  How blind a girl can be To miss you hide your ring Thought about everything I m so naive imagining and all that  Did it again  love I got it all wrong But it felt so right I can t believe it  And all the mistakes That went on for too long Wish there was a way I could delete it  Eh  eh  eh  eh Ah  ah  ah  ah  It may seem to you that I am in a place Where I m losing the direction of my life But I m sure that this is nothing but a phase  Right back at ya   cause I ll survive     It may seem to you that I am in a place Where I m losing the direction of my life But I m sure that this is nothing but a phase  Right back at ya   cause I ll survive  Did it again  love I got it all wrong But it felt so right I can t believe it  And all the mistakes That went on for too long Wish there was a way I could delete it  Eh  eh  eh  eh Ah  ah  ah  ah', '2009', 'Did It Again', '6' ),
( '12', '250', ' Blue Skies   We ve been waiting  anticipating change coming our way You re my baby through the bad lights to the greater days  I know that something good is waiting just around the corner There s a new day dawning  there s a new life for us Got to keep on holding on for just a little longer I know  But that it s gonna be blue skies for you and I We ll step out of the shadows and walk into the light Yeah it s gonna be blue skies for you and I But my heart beats slow as the storm carries on up high And the clouds roll by  I can feel it  it s a comet  fast and fierce and wild I can see it every time I look into those eyes  Tell me is it really gonna storm again Will the sky turn dark  will the rain begin  I wanna be with you wherever lightning strikes cause I know  That it s gonna be blue skies for you and I We ll step out of the shadows and walk into the light Yeah it s gonna be blue skies for you and I But my heart beats slow as the storm carries on up high And the clouds roll by And the clouds roll by I couldn t stand the rain for one more day I know we can make it go away Can you feel it  Like a fever  burning till it breaks Blue skies for you and I We ll step out of the shadows and walk into the light Yeah it s gonna be blue skies for you and I But my heart beats slow as the storm carries on up high And the clouds roll by  Blue skies  blue skies  and the clouds roll by  Blue skies  blue skies  and the clouds roll by  Blue skies  blue skies  and the clouds roll by  Blue skies  blue skies  and the clouds roll by  Blue  blue  blue  blue  blue  blue   ', '2015', 'Blue Skies', '9' ),
( '13', '232', 'It feels like a perfect night to dress up like hipsters And make fun of our exes  uh uh uh uhIt feels like a perfect night for breakfast at midnight To fall in love with strangers  uh uh uh uhYeaaaah We re happy free confused and lonely at the same time It s miserable and magical  oh yeah Tonight s the night when we forget about the deadlines It s time  uh uhI don t know about you but I m feeling 22 Everything will be alright if you keep me next to you You don t know about me but I bet you want to Everything will be alright if we just keep dancing like we re 22  22It seems like one of those nights This place is too crowded too many cool kids  Who s Taylor Swift anyway  Ugh  It seems like one of those nights We ditch the whole scene and end up dreaming instead of sleepingYeaaaah We re happy free confused and lonely in the best way It s miserable and magical  oh yeah Tonight s the night when we forget about the heartbreaks It s time  uh uhI don t know about you but im feeling 22 Everything will be alright if you keep me next to you You don t know about me but I bet you want to Everything will be alright if we just keep dancing like we re 22  22 I don t know about you 22  22 It feels like one of those nights We ditch the whole scene It feels like one of those nights We won t be sleepingIt feels like one of those nights You look like bad news  I gotta have you  I gotta have youI don t know about you but im feeling 22 Everything will be alright if you keep me next to you You don t know about me but I bet you want to Everything will be alright if we just keep dancing like we re 22  22Dancing like 22 Yeah  22  yeah yeahIt feels like one of those nights We ditch the whole scene It feels like one of those nights We won t be sleepingIt feels like one of those nights You look like bad news I gotta have you  I gotta have you', '2012', '22', '7' ),
( '14', '299', ' Gary Lightbody   I find myself at your door Just like all those times before I m not sure how I got there All roads they lead me here  I imagine you are home In your room  all alone And you open your eyes into mine And everything feels better   Both   And right before your eyes I m breaking  no past No reasons why Just you and me  This is the last time I m asking you this Put my name at the top of your list This is the last time I m asking you why You break my heart in the blink of an eye  eye  eye   Taylor Swift   You find yourself at my door Just like all those times before You wear your best apology But I was there to watch you leave  And all the times I let you in Just for you to go again Disappear when you come back Everything is better   Both   And right before your eyes I m aching  no past Nowhere to hide Just you and me  This is the last time I m asking you this Put my name at the top of your list This is the last time I m asking you why You break my heart in the blink of an eye  eye  eye   Taylor Swift   This is the last time you tell me I ve got it wrong  Gary Lightbody   This is the last time I say it s been you all along  Taylor Swift   This is the last time I let you in my door  Gary Lightbody   This is the last time  I won t hurt you anymore  Oh  oh  oh  This is the last time I m asking you this Put my name at the top of your list This is the last time I m asking you why You break my heart in the blink of an eye  This is the last time I m asking you Last time I m asking you Last time I m asking you this This is the last time I m asking you Last time I m asking you Last time I m asking you this This is the last time I m asking you Last time I m asking you Last time I m asking you this This is the last time I m asking you Last time I m asking you Last time I m asking you this', '2012', 'The Last Time', '7' ),
( '15', '244', ' Taylor Swift   Future   I wanna be your end game I wanna be your first string I wanna be your A Team I wanna be your end game  end game  Big reputation  big reputation Ooh  you and me  we got big reputations Ah  and you heard about me Ooh  I got some big enemies  yeah  Big reputation  big reputation Ooh  you and me would be a big conversation Ah  and I heard about you  yeah  Ooh  you like the bad ones  too   Future   You so dope  don t overdose I m so stoked  I need a toast We do the most  I m in the Ghost like I m whippin  a boat I got a reputation  girl  that don t precede me  yeah  I m one call away whenever you need me  yeah  I m in a G5  yeah   come to the A Side  yeah  I got a bad boy persona  that s what they like  what they like  You love it  I love it  too   cause you my type  you my type  You hold me down and I protect you with my life   Taylor Swift   Future   I don t wanna touch you  I don t wanna be Just another ex love you don t wanna see I don t wanna miss you  I don t wanna miss you  Like the other girls do I don t wanna hurt you  I just wanna be Drinking on a beach with you all over me I know what they all say  I know what they all say  But I ain t tryna play   Taylor Swift   I wanna be your end game  End game  I wanna be your first string  First string  I wanna be your A Team  A Team  I wanna be your end game  end game   Ed Sheeran   Knew her when I was young Reconnected when we were little bit older  both sprung I got issues and chips on both of my shoulders Reputation precedes me  in rumors I m knee deep The truth is it s easier to ignore it  believe me Even when we d argue  we d not do it for long And you understand the good and bad end up in a song For all your beautiful traits and the way you do it with ease For all my flaws  paranoia and insecurities I ve made mistakes and made some choices  that s hard to deny After the storm  something was born on the 4th of July I ve passed days without fun  this end game is the one With four words on the tip of my tongue  I ll never say it   Taylor Swift   I don t wanna touch you  I don t wanna be Just another ex love you don t wanna see I don t wanna miss you  I don t wanna miss you  Like the other girls do I don t wanna hurt you  I just wanna be Drinking on a beach with you all over me I know what they all say  yeah  but I ain t tryna play   Taylor Swift   I wanna be your end game  End game  I wanna be your first string  Wanna be your first string  I wanna be your A Team  A Team  I wanna be your end game  end game   Taylor Swift   Future   Big reputation  big reputation Ooh  you and me  we got big reputations Ah  and you heard about me Oh  I got some big enemies Hey  big reputation  big reputation Ooh  you and me would be a big conversation Ah  and I heard about you Ooh  you like the bad ones  too   Taylor Swift   I hit you like bang We tried to forget it  but we just couldn t And I bury hatchets  but I keep maps of where I put  em Reputation precedes me  they told you I m crazy I swear I don t love the drama  it loves me And I can t let you go  your hand prints on my soul It s like your eyes are liquor  it s like your body is gold You ve been calling my bluff on all my usual tricks So here s the truth from my red lips   Taylor Swift  Future   Ed Sheeran   I wanna be your end game  End game  I wanna be your first string  Me and you  I wanna be your A Team  Be your A Team now  I wanna be your end game  end game I wanna be your end game  oh  I do  I wanna be your first string  first string  I wanna be your A Team  A Team  I wanna be your end game  end game', '2018', 'End Game', '8' ),
( '16', '258', 'I never trust a narcissist  but they love me So I play  em like a violin And I make it look oh so easy   Cause for every lie I tell them  they tell me three This is how the world works Now all he thinks about is me  I can feel the flames on my skin Crimson red paint on my lips If a man talks shit Then I owe him nothing I don t regret it one bit  Cause he had it coming  They say I did something bad Then why s it feel so good  They say I did something bad But why s it feel so good  Most fun I ever had And I d do it over and over and over again if I could It just felt so good  good  I never trust a playboy  but they love me So I fly  em all around the world And I let them think they saved me  They never see it comin   what I do next This is how the world works You gotta leave before you get left  I can feel the flames on my skin He says   Don t throw away a good thing   But if he drops my name Then I owe him nothin  And if he spends my change Then he had it comin   They say I did something bad Then why s it feel so good  They say I did something bad But why s it feel so good  Most fun I ever had And I d do it over and over and over again if I could It just felt so good  good  It just felt so good  They re burning all the witches  even if you aren t one They got their pitchforks and proof  their receipts and reasons  They re burning all the witches  even if you aren t one So light me up  light me up   light me up  light me up  Light me up  go ahead and light me up  light me up   Light me up  light me up   light me up  light me up  Light me up  light me up   light me up  They say I did something bad  oh  Then why s it feel so good   so good  They say I did something bad But why s it feel so good  Most fun I ever had  most fun I ever had  And I d do it over and over and over again if I could It just felt so good  good   good  Oh  you say I did something bad  You say I did something bad   Why s it feel so good  good  So bad  why s it feel so good  Why s it feel  why s it feel so good   bad  It just felt so good  good ', '2018', 'I Did Something Bad', '8' );
-- ---------------------------------------------------------


-- CREATE INDEX "Artist" ---------------------------------------
CREATE INDEX `Artist` USING BTREE ON `Albums`( `Artist` );
-- -------------------------------------------------------------


-- CREATE INDEX "Album" ----------------------------------------
CREATE INDEX `Album` USING BTREE ON `Songs`( `Album` );
-- -------------------------------------------------------------


-- CREATE LINK "Albums_ibfk_1" ---------------------------------
ALTER TABLE `Albums`
	ADD CONSTRAINT `Albums_ibfk_1` FOREIGN KEY ( `Artist` )
	REFERENCES `Artists`( `ArtistID` )
	ON DELETE Cascade
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "Songs_ibfk_1" ----------------------------------
ALTER TABLE `Songs`
	ADD CONSTRAINT `Songs_ibfk_1` FOREIGN KEY ( `Album` )
	REFERENCES `Albums`( `AlbumID` )
	ON DELETE Cascade
	ON UPDATE No Action;
-- -------------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


