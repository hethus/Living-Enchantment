package com.clownvin.livingenchantment.personality;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PersonalityLoader {
    public static final File personalityLocation = new File("./config/personalities/");

    public static Personality[] getPersonalities() {
        ArrayList<Personality> personalities = new ArrayList<>(10);
        if (!personalityLocation.exists()) {
            personalityLocation.mkdirs();
        }
        createBasePersonalities();
        File[] personalityConfigs = personalityLocation.listFiles();
        for (File personalityConfig : personalityConfigs) {
            if (!personalityConfig.getName().endsWith(".cfg"))
                continue;
            personalities.add(loadPersonality(personalityConfig));
        }
        personalities.add(Personality.HEROBRINE);
        return personalities.toArray(new Personality[personalities.size()]);
    }

    public static void createPersonalityFile(Personality p) {
        File file = new File("./config/personalities/" + p.name + ".cfg");
        if (file.exists())
            return;
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write("[name]\n" + p.name + "\n[weight]\n" + p.weight + "\n[use]\n");
            for (int i = 0; i < p.onUse.length; i++) {
                writer.write(p.onUse[i]);
                writer.newLine();
            }
            writer.write("[useweight]\n" + p.useOdds + "\n[kill]\n");
            for (int i = 0; i < p.onKill.length; i++) {
                writer.write(p.onKill[i]);
                writer.newLine();
            }
            writer.write("[killweight]\n" + p.killOdds + "\n[death]\n");
            for (int i = 0; i < p.onDeath.length; i++) {
                writer.write(p.onDeath[i]);
                writer.newLine();
            }
            writer.write("[levelup]\n");
            for (int i = 0; i < p.onLevelUp.length; i++) {
                writer.write(p.onLevelUp[i]);
                writer.newLine();
            }
            writer.write("[hurt]\n");
            for (int i = 0; i < p.onHurt.length; i++) {
                writer.write(p.onHurt[i]);
                writer.newLine();
            }
            writer.write("[hurtweight]\n" + p.hurtOdds + "\n[25%durability]\n");
            for (int i = 0; i < p.twentyPercent.length; i++) {
                writer.write(p.twentyPercent[i]);
                writer.newLine();
            }
            writer.write("[10%durability]\n");
            for (int i = 0; i < p.fivePercent.length; i++) {
                writer.write(p.fivePercent[i]);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBasePersonalities() {
        createPersonalityFile(new Personality(10, "lascivo",
                new String[]{ //Use
                        "Sim... Sim.. Sim!!!",
                        "Me use mais, $user! Sim!",
                        "Eu amo quando você me usa assim, $user.",
                        "Oh $user, você sabe exatamente o que eu quero!",
                        "Sim, $user! Sim! Use-me ASSIM!",
                        "Oh meu Deus isso é tão bom, $user!",
                        "Mais! mais! MAIS!",
                        "Deus, isso é tão bom!",
                        "$user, Espero que isso nunca pare!",
                        "$user, eu me sinto tão bem!",
                        "Continue, $user!",
                        "Ah sim, assim mesmo $user!",
                        "Rápido $user, rápido! Mais!",
                        "siiiiim! isso é tão BOOOM!",
                        "oh meu Deus, $user, é tão bom!",
                        "Nunca vou conseguir me cansar disso!",
                        "Eu preciso de mais, $user!",
                        "Mais!",
                        "Sim!",
                        "Me dê isto, $user!",
                },
                7,
                new String[]{ //Kill
                        "Eles morreram!",
                },
                80,
                new String[]{ //Death
                        "Aww, você morreu, $user? Volte depressa!",
                        "Você é tudo que ey tenho, $user! Eu preciso de você!",
                        "Volte logo! eu preciso de você, $user!",
                        "Não me deixe aqui, $user! Eu preciso ser usado!"
                },
                new String[]{ //Level Up
                        "Oh, é tão bom, $user! (Level $level)",
                        "Meu poder esta crescendo, $user! (Level $level)",
                        "Me sinto tão revigorado! (Level $level)",
                        "Então é assim que é viver! (Level $level)",
                        "Esse poder... isso é tão bom! (Level $level)",
                        "eu poderia me acostumar com isso... (Level $level)"
                },
                new String[]{ //On Hurt
                        "Aposto que dói.",
                        "Não deveria ser bom.",
                        "Eu gostaria que $user me desse um tapa assim!",
                        "Só um pouco mais, $user.",
                },
                1,
                new String[]{ //Twenty percent
                        "Estou ficando mais fraco, $user. ($durability durabilidade restante)",
                        "Estou começando a me sentir fraco, $user. ($durability durabilidade restante)",
                        "Não se esqueça de mim, $user! ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Eu não me sinto bem... ($durability durabilidade restante!)",
                        "Não pode ser assim que isso termina, $user! ($durability durabilidade restante!)",
                        "Ainda não estou pronto para morrer, $user! ($durability durabilidade restante!)",
                }));
        createPersonalityFile(new Personality(10, "Agressivo",
                new String[]{ //Use
                        "Yay!",
                        "Eu consegui, $user! INCRÍVEL!",
                        "Uau, aquele foi difícil.",
                        "Não pare, $user! Isso é muito divertido!",
                        "Todo esse exercício é tão bom, $user!",
                        "Vamos continuar, $user!",
                },
                24,
                new String[]{ //Kill
                        "MORRA MORRA MORRA! Simm!",
                        "Morra!",
                        "Ha! Eles morreram!",
                        "Heheh, isso tinha que doer.",
                        "Morra morra morra!",
                },
                5,
                new String[]{ //Death
                        "Você ahn... você morreu.",
                        "Voce esta voltando para mim, certo $user?",
                        "Não me deixe aqui, $user!!!",
                },
                new String[]{ //Level Up
                        "Siim! Mais PODER! (Level $level)",
                        "Me sinto tão forte! (Level $level)",
                        "$user! $user! Olha como estou forte agora! (Level $level)",
                        "Eu sou incrível ou o quê, $user?! (Level $level)",
                        "Mais... PODERRR! (Level $level)",
                },
                new String[]{ //On Hurt
                        "Uau, isso deve doer!",
                        "Tome isso!",
                        "Ihaaa! Pegue um pouco disso!",
                        "Ainda não teve o suficiente?",
                        "Há muito mais de onde isso veio!"
                },
                14,
                new String[]{ //Twenty percent
                        "Estou ficando mais fraco, $user. ($durability durabilidade restante)",
                        "Estou começando a me sentir fraco, $user. ($durability durabilidade restante)",
                        "Não se esqueça de mim, $user! ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Eu não me sinto bem... ($durability durabilidade restante!)",
                        "Não pode ser assim que isso termina, $user! Queria matar mais ($durability durabilidade restante!)",
                        "Ainda não estou pronto para morrer, $user! ($durability durabilidade restante!)",
                }));
        createPersonalityFile(new Personality(10, "Preguiçoso",
                new String[]{ //Use
                        "É isso aí. Terminamos... certo?",
                        "Ei, $user, terminamos agora, certo?",
                        "Por favor, não mais...",
                        "$user, paree, eu não aguento mais!",
                        "Eu não sei quanto trabalho mais posso aguentar!",
                        "$user, Não tenho certeza se vou durar muito mais tempo!",
                        "Todo esse trabalho está me matando..",
                        "AFF, $user, este é um trabalho exaustivo!",
                        "Você realmente precisa fazer isso? Você não prefere dormir? Eu gostaria...",
                        "Vamos! vamos dormir agora. Estou cansado de trabalhar...",
                        "$user, bastante trabalho. Vamos tirar uma soneca!",
                        "Não mais! Por favor! Estou te implorando, $user",
                        "Nós terminamos né?"
                },
                24,
                new String[]{ //Kill
                        "Veja, $user, eles estão mortos.",
                        "Bem bom, $user!",
                        "Matar dá muito trabalho! Estou tão cansado!",
                        "Temos que matá-los, $user? Não podemos apenas dormir?",
                        "Eu só quero uma pausa, $user"
                },
                12,
                new String[]{ //Death
                        "finalmente, agora posso descansar tambem!",
                        "Ai! Você parece estar com dor, $user.",
                        "Certifique-se de voltar para mim, $user!",
                        "Não se esqueça de mim, $user!"
                },
                new String[]{ //Level Up
                        "Ah sim, mais poder! Agora de volta a dormir... (Level $level)",
                        "Eu posso sentir o poder fluindo através de mim, $user! ... e agora estou cansado. (Level $level)",
                        "Me sinto... forte, $user (Level $level)!",
                        "É assim que é ser bom para alguma coisa? (Level $level)"
                },
                new String[]{ //On Hurt
                        "Ai! Aposto que vão sentir isso amanhã, $user!",
                        "Ooo, parece que deve doer!",
                        "Aiii!",
                        "Todo esse combate está me deixando tão cansado, $user!",
                        "Tome isso!"
                },
                16,
                new String[]{ //Twenty percent
                        "Estou ficando mais fraco, $user. Acho que preciso descansar. ($durability durabilidade restante)",
                        "Estou começando a me sentir mais fraco, $user. ($durability durabilidade restante)",
                        "Não se esqueça de mim, $user! ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "O fim finalmente chegou? ($durability durabilidade restante!)",
                        "É aqui que nos separamos, $user? ($durability durabilidade restante!)",
                        "Ainda não estou pronto para morrer, $user! ($durability durabilidade restante!)",
                }));
        createPersonalityFile(new Personality(10, "Deprimido",
                new String[]{ //Use
                        "$user, isso pode esperar? eu estou muito exausto.",
                        "Você realmente precisa me usar agora, $user?",
                        "...Sigh...",
                        "Eu só quero dormir...",
                        "Já estamos quase terminando, $user? eu estou muito... cansado.",
                },
                48,
                new String[]{ //Kill
                        "Eles estão melhor agora de qualquer maneira, $user",
                        "É uma pena que não posso fazer você me matar em vez disso, $user",
                        "...Sortudos",
                        "Se.. apenas..."
                },
                22,
                new String[]{ //Death
                        "Não $user, Você também não!",
                        "Não me deixe aqui, $user! Me leve com você!",
                        "Você tem sorte, $user...",
                        "$user, Eu queria ser você... Se eu tivesse essa sorte"
                },
                new String[]{ //Level Up
                        "$user, Me sinto um pouco melhor ($level)",
                        "Eii, $user, Estou começando a me sentir melhor... não, espere, não estou não. ($level)",
                        "Eu não mereço isso, $user ($level)",
                        "Porque sempre me ajuda, $user? ($level)",
                        "$user, simplesmente pare! Eu não preciso da sua simpatia ($level).",
                },
                new String[]{ //On Hurt
                        "Isso não é muito legal da sua parte, $user...",
                        "Talvez você não deva machucar os outros, $user...",
                        "$user, tem certeza que isso é uma coisa boa?",
                        "$user, quando você vai parar de me balançar? estou cansado.",
                },
                18,
                new String[]{ //Twenty percent
                        "Minha fraqueza está crescendo, $user. ($durability durabilidade restante)",
                        "Estou começando a me sentir mais perto do fim, $user. ($durability durabilidade restante)",
                        "Não me esqueça, $user! ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "O fim finalmente chegou?? ($durability durabilidade restante!)",
                        "É aqui que nos separamos, $user? ($durability durabilidade restante!)",
                        "Estou indo... $user... ($durability durabilidade restante!)",
                }));
        createPersonalityFile(new Personality(10, "Demoníaco",
                new String[]{ //Use
                        "sqaeae aoze",
                        "iz yiz yixjak qae xa song?",
                        "gae raeq yort za",
                        "ona esaeu tired esaq, suzor?"
                },
                32,
                new String[]{ //Kill
                        "ya mchl't iz iegd",
                        "yiz aera iz zira",
                        "yaes labbia o maeaeh",
                        "yaes kaeq s'oq yaes dralsjik",
                        "$user, yoq iz maen esaeu"
                },
                8,
                new String[]{ //Death
                        "Maeaeh, sael gona esaeu gia aer za!",
                        "I ohloesz tral esaeu labbia laot",
                        "Doyaqiy",
                        "$user, gae raeq gia aer za!",
                        "$user, rae!"
                },
                new String[]{ //Level Up
                        "Zes daelabbi grows qae chwah! (Level $level)",
                        "za maah zae ednaerdh, rael yoq za chwah! (Level $level)",
                        "I zaa ya laenhg. (Level $level)",
                        "$user, xa yonamuh, I oz rael chwaw! (Level $level)"
                },
                new String[]{ //On Hurt
                        "Qoeda zes wedrk",
                        "Esaeu l'tozz kazk!",
                        "esaeu lizz moih",
                        "re zeebnir ez oep.",
                        "qoeda qnua doir!",
                        "esaeu maeaehil't ynaoquna!",
                        "chq uz vanquish yiz foe, $user!",
                        "$user, yiz ynaoquna gaeaz raeq trael aeun ednardhy! chq uz l'tael iq!",
                        "Esaeu lizz trael haeza",
                        "$user, yiz ynaoquna zoes raeq xa allowed qae apied!",
                },
                12,
                new String[]{ //Twenty percent
                        "$user, ao bnzl zegsl ni jlmgbo dlwblhld! ($durability durabilidade restante)",
                        "Oep apih jeh zegvlh he rlmb al, $user! ($durability durabilidade restante)",
                        "Ao lmcjlii vgei... ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Oep mjh hrmh n irepbd wlgnir, $user? ($durability durabilidade restante!)",
                        "Ro ej'h oep rlbw al, $user? ($durability durabilidade restante!)",
                        "N ma jlmgbo dlihgeold, $user! ($durability durabilidade restante!)",
                }));
        createPersonalityFile(new Personality(10, "Silencioso",
                new String[]{ //Use
                        "'-'",
                        ".-.",
                        ">-<",
                        "( ͡❛ ͜ʖ ͡❛)",
                },
                40,
                new String[]{ //Kill
                        ":s",
                        "O.O",
                        "._.",
                },
                40,
                new String[]{ //Death
                        ";-;",
                        ";;---;;",
                        "( ﾟдﾟ)",
                        "(ㆆ_ㆆ)",
                },
                new String[]{ //Level Up
                        "¯\_(ツ)_/¯ (Level $level)",
                        "◕‿◕ (Level $level)",
                        "^_^ (Level $level)",
                },
                new String[]{ //On Hurt
                        "ಠ_ಠ",
                        "( ˘︹˘ )",
                        "(ง︡'-'︠)ง",
                        "(≖_≖ )",
                },
                40,
                new String[]{ //Twenty percent
                        "(╥﹏╥) ($durability durabilidade restante)",
                        "ó_ò ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "＞︿＜ ($durability ddurabilidade restante)",
                        "＋▽＋ ($durability durabilidade restante)",
                        "+_+ ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Gato",
                new String[]{ //Use
                        "Miau.",
                        "Miiaau.",
                        "Meew.",
                        "Hiss!",
                        "Miau??",
                },
                24,
                new String[]{ //Kill
                        "Miau!",
                        "Hiss!",
                        "Hisss!",
                },
                12,
                new String[]{ //Death
                        "Miau...",
                        "Miau... miau?",
                        "Miau...?",
                },
                new String[]{ //Level Up
                        "Miau! (Level $level)",
                },
                new String[]{ //On Hurt
                        "Miau!",
                        "Hiss!",
                        "Hiss!",
                        "Hisss!",
                }, 8,
                new String[]{ //Twenty percent
                        "Miau! ($durability durabilidade restante)",
                        "Miau? ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Mrrrrow! ($durability durabilidade restante)",
                        "Miau! ($durability durabilidade restante)",
                        "Miau??? Mrrrrow Mrrrrow! ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Cachorro",
                new String[]{ //Use
                        "Au au.",
                        "Áuuuuu.",
                        "Khainnn.",
                        "Au! Au! Au!",
                        "*farejando*",
                },
                24,
                new String[]{ //Kill
                        "Au!",
                        "AU AU AU!",
                        "Au! AU! Au!",
                },
                12,
                new String[]{ //Death
                        "Khai...nn.",
                        "khain.....",
                },
                new String[]{ //Level Up
                        "Au! (Level $level)",
                        "AUU! (Level $level)",
                },
                new String[]{ //On Hurt
                        "Au!",
                        "AUAU!",
                        "Au au au!",
                        "Auuuuuuuu.",
                        "*Rrrrrrr*",
                }, 8,
                new String[]{ //Twenty percent
                        "Khainnn. ($durability durabilidade restante)",
                        "Rrrrr. ($durability durabilidade restante)",
                        "Au! Auuuuu! ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Khainnn. ($durability durabilidade restante)",
                        "*choramingando* ($durability durabilidade restante)",
                        "AUUuu! ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, ".BuGa_do",
                new String[]{ //Use
                        "§k c  drtbs fn  Wsneathc gt n  e. ceiapk½p  s t+thicFe  dce",
                        "§kemono,h    ?. eesf echh²aeane=e.TetVtd e²e½t.",
                        "§k slw  ½i  e b  wfd ovty t sa½wtuhHirchrt iecu)aoirc",
                        "§kcaygVennenr slw  ½i H",
                        "§k b  wfd ovty t sa½wtuhHirchrt iecu)aoir"
                },
                24,
                new String[]{ //Kill
                        "§k caf  lwu s  derh=ccn wae epo a    a   x",
                        "§kyV upneiehkah",
                        "§kl(  un tnyW  arta( "
                },
                12,
                new String[]{ //Death
                        "§kshs( i t. h oune pyf atw  oosWha rts tbmedhhe( r  = fei)lWifpndi s a tr b(ay t u cb  caf  lwu s",
                        "§kneiehkah tfc eept ½mo  ete +fla)tl a ky e  neep rlc lw u nx knmcT es nqimq .i ol ot c c/qon ",
                        "§ktalhl(  un tnyW"
                },
                new String[]{ //Level Up
                        "§kpe ecofs soyasd§r (Level $level)",
                        "§kt morsa ) kam detiriti §r (Level $level)",
                        "§kso+ Wt)ci  ten idqr k om n²tia rron = i o§r (Level $level)"
                },
                new String[]{ //On Hurt
                        "§kKary  d",
                        "§kape /nhros,n h",
                        "§kk pyn cr i  i  tkho ic d(m  t)t",
                        "§krsdile"
                }, 8,
                new String[]{ //Twenty percent
                        "§km a displacement kinetic energy of the resultant x? We caus§r ($durability durabilidade restante)",
                        "§kin call product of a particle o§r ($durability durabilidade restante)",
                        "§k then stant and V - ½ ( ½ ( V is the represe§r ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "§kd the squationstant x? We mas§r ($durability durabilidade restante!)",
                        "§krticle of the resent acti§r ($durability durabilidade restante!)",
                        "§k stant and V - ½ ( ½ ( V is the represent kineticle on a partic energy of its speed at t§r ($durability durabilidade restante!)",
                }));
        createPersonalityFile(new Personality(10, "Alienígena",
                new String[]{ //Use
                        "⌇⍾⏃⟒⏃⟒ ⏃⍜⋉⟒",
                        "⟟⋉ ⊬⟟⋉ ⊬⟟⌖⟊⏃☍ ⍾⏃⟒ ⌖⏃ ⌇⍜⋏☌?",
                        "☌⏃⟒ ⍀⏃⟒⍾ ⊬⍜⍀⏁ ⋉⏃",
                        "⍜⋏⏃ ⟒⌇⏃⟒⎍ ⏁⟟⍀⟒⎅ ⟒⌇⏃⍾, ⌇⎍⋉⍜⍀?"
                },
                32,
                new String[]{ //Kill
                        "⊬⏃ ⋔☊⊑⌰'⏁ ⟟⋉ ⟟⟒☌⎅",
                        "⊬⟟⋉ ⏃⟒⍀⏃ ⟟⋉ ⋉⟟⍀⏃",
                        "⊬⏃⟒⌇ ⌰⏃⏚⏚⟟⏃ ⍜ ⋔⏃⟒⏃⟒⊑",
                        "⊬⏃⟒⌇ ☍⏃⟒⍾ ⌇'⍜⍾ ⊬⏃⟒⌇ ⎅⍀⏃⌰⌇⟊⟟☍",
                        "⎍⌇⟒⍀, ⊬⍜⍾ ⟟⋉ ⋔⏃⟒⋏ ⟒⌇⏃⟒⎍"
                },
                8,
                new String[]{ //Death
                        "⋔⏃⟒⏃⟒⊑, ⌇⏃⟒⌰ ☌⍜⋏⏃ ⟒⌇⏃⟒⎍ ☌⟟⏃ ⏃⟒⍀ ⋉⏃!",
                        "⟟ ⍜⊑⌰⍜⟒⌇⋉ ⏁⍀⏃⌰ ⟒⌇⏃⟒⎍ ⌰⏃⏚⏚⟟⏃ ⌰⏃⍜⏁",
                        "⎅⍜⊬⏃⍾⟟⊬",
                        "⎍⌇⟒⍀, ☌⏃⟒ ⍀⏃⟒⍾ ☌⟟⏃ ⏃⟒⍀ ⋉⏃!",
                        "⎍⌇⟒⍀, ⍀⏃⟒!"
                },
                new String[]{ //Level Up
                        "⋉⟒⌇ ⎅⏃⟒⌰⏃⏚⏚⟟ ☌⍀⍜⍙⌇ ⍾⏃⟒ ☊⊑⍙⏃⊑! (Level $level)",
                        "⋉⏃ ⋔⏃⏃⊑ ⋉⏃⟒ ⟒⎅⋏⏃⟒⍀⎅⊑, ⍀⏃⟒⌰ ⊬⍜⍾ ⋉⏃ ☊⊑⍙⏃⊑! (Level $level)",
                        "⟟ ⋉⏃⏃ ⊬⏃ ⌰⏃⟒⋏⊑☌. (Level $level)",
                        "⎍⌇⟒⍀, ⌖⏃ ⊬⍜⋏⏃⋔⎍⊑, ⟟ ⍜⋉ ⍀⏃⟒⌰ ☊⊑⍙⏃⍙! (Level $level)"
                },
                new String[]{ //On Hurt
                        "⍾⍜⟒⎅⏃ ⋉⟒⌇ ⍙⟒⎅⍀☍",
                        "⟒⌇⏃⟒⎍ ⌰'⏁⍜⋉⋉ ☍⏃⋉☍!",
                        "⟒⌇⏃⟒⎍ ⌰⟟⋉⋉ ⋔⍜⟟⊑",
                        "⍀⟒ ⋉⟒⟒⏚⋏⟟⍀ ⟒⋉ ⍜⟒⌿.",
                        "⍾⍜⟒⎅⏃ ⍾⋏⎍⏃ ⎅⍜⟟⍀!",
                        "⟒⌇⏃⟒⎍ ⋔⏃⟒⏃⟒⊑⟟⌰'⏁ ⊬⋏⏃⍜⍾⎍⋏⏃!",
                        "☊⊑⍾ ⎍⋉ ⎐⏃⋏⍾⎍⟟⌇⊑ ⊬⟟⋉ ⎎⍜⟒, ⎍⌇⟒⍀!",
                        "⎍⌇⟒⍀, ⊬⟟⋉ ⊬⋏⏃⍜⍾⎍⋏⏃ ☌⏃⟒⏃⋉ ⍀⏃⟒⍾ ⏁⍀⏃⟒⌰ ⏃⟒⎍⋏ ⟒⎅⋏⏃⍀⎅⊑⊬! ☊⊑⍾ ⎍⋉ ⌰'⏁⏃⟒⌰ ⟟⍾!",
                        "⟒⌇⏃⟒⎍ ⌰⟟⋉⋉ ⏁⍀⏃⟒⌰ ⊑⏃⟒⋉⏃",
                        "⎍⌇⟒⍀, ⊬⟟⋉ ⊬⋏⏃⍜⍾⎍⋏⏃ ⋉⍜⟒⌇ ⍀⏃⟒⍾ ⌖⏃ ⏃⌰⌰⍜⍙⟒⎅ ⍾⏃⟒ ⏃⌿⟟⟒⎅!",
                },
                12,
                new String[]{ //Twenty percent
                        "⋔⊬ ⌰⟟⎎⟒ ⟒⌇⌇⟒⋏☊⟒ ⟟⌇ ☌⟒⏁⏁⟟⋏☌ ⎎⏃⟟⍀⌰⊬ ⌰⍜⍙... ($durability durabilidade restante)",
                        "⟟⌇⋏'⏁ ⟟⏁ ⏁⟟⋔⟒ ⊬⍜⎍ ⍀⟒⌿⏃⟟⍀⟒⎅ ⋔⟒? ($durability durabilidade restante)",
                        "⟟'⋔ ⎎⟒⟒⌰⟟⋏☌ ⌿⍀⟒⏁⏁⊬ ⍙⟒⏃☍ ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "⋔⊬ ⌰⟟⎎⟒ ⟒⌇⌇⟒⋏☊⟒ ⟟⌇ ☌⟒⏁⏁⟟⋏☌ ⎎⏃⟟⍀⌰⊬ ⌰⍜⍙... ($durability durabilidade restante!)",
                        "⟟⌇⋏'⏁ ⟟⏁ ⏁⟟⋔⟒ ⊬⍜⎍ ⍀⟒⌿⏃⟟⍀⟒⎅ ⋔⟒? ($durability durabilidade restante!)",
                        "⟟'⋔ ⎎⟒⟒⌰⟟⋏☌ ⌿⍀⟒⏁⏁⊬ ⍙⟒⏃☍ ($durability durabilidade restante!)",
                }));
        createPersonalityFile(new Personality(10, "Hiperativo",
                new String[]{ //Use
                        "De novo! De novo!",
                        "Isso é tão divertido, vamos continuar fazendo isso, $user!",
                        "Continuaaaa!",
                        "Yay!",
                        "Eu poderia fazer isso o dia todo!",
                        "$user, não pare! Isso é tão divertido!",
                        "Eu quero maisss!",
                        "Isso é muito emocionante! Não concorda, $user?",
                },
                24,
                new String[]{ //Kill
                        "Nós realmente mostramos a eles!",
                        "Bom trabalho, $user!",
                        "Matar dá muito trabalho! Eu amo isso!",
                },
                12,
                new String[]{ //Death
                        "Ah não! Esse é o fim?",
                        "Nããão! Nós estávamos apenas começando!",
                        "Vamos pegá-los da próxima vez, certo? $user?... Oh, você morreu.",
                        "Nunca se esqueça de mim, $user!",
                },
                new String[]{ //Level Up
                        "Ah sim, mais poder! (Level $level)",
                        "Posso sentir o poder fluindo por mim, $user! Vamos continuar! (Level $level)",
                        "Já me sinto mais forte, $user! (Level $level)!",
                },
                new String[]{ //On Hurt
                        "Ai! Aposto que vão sentir isso amanhã, $user!",
                        "Ooo, parece que deve doer!",
                        "AII!",
                        "TOME ISSO!",
                },
                16,
                new String[]{ //Twenty percent
                        "Estou sentindo dor, $user. ($durability durabilidade restante)",
                        "Não estou tão bem como antes, $user. ($durability durabilidade restante)",
                        "Eu fui útil $user? Não se esqueça de mim. ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "(Ahhn...) É... é este o fim da nossa parceria, $user? ($durability durabilidade restante!)",
                        "Eu realmente estou fraco, $user... ($durability durabilidade restante!)",
                        "Eu não quero morrer, $user! ($durability durabilidade restante!)",
                        "Eu acho... é isso, hein $user? Acabou.... ($durability durabilidade restante!)",
                }));
        createPersonalityFile(new Personality(10, "Gamer",
                new String[]{ //Use
                        "Será que se tivesse led não seria melhor?",
                        "$user, isso não cansa não? Podiamos jogar um pouco pra relaxar",
                        "EU FAZIA ISSO EM UM JOGO ANTES KKKKKK",
                        "Eu pensei que ia ser o jogador não o trabalhador!",
                        "Não da pra fazer nenhum combo pra ir mais rápido, $user?",
                        "Acho que aprendi com o Davi, vi ele quebrando uns blocos assim",
                },
                24,
                new String[]{ //Kill
                        "GG",
                        "iziiii de mais",
                        "$user, eram bots?",
                        "APRENDI COM O ALAN",
                },
                12,
                new String[]{ //Death
                        "Ah, morreu... rlx, vai respawnar",
                        "GAME OVER, pressione 'CONTINUE'",
                },
                new String[]{ //Level Up
                        "Subindo de nível e ficando apelão! (Level $level)",
                        "Ei $user, não posso voltar base e comprar item? (Level $level)",
                        "Ta ficando izi ou eu que to forte? (Level $level)",
                },
                new String[]{ //On Hurt
                        "Eles não sabem que estamos em call!",
                        "$user, vamos mandar ver, preciso de XP.",
                        "Cai dentro, sou desafiante!",
                        "cadê o PvP, $user?",
                        "Eu sou main eu mesmo, sei como dar dano comigo.... Meio estranho, mas é a verdade.",
                        "Será que o Viniccius13 ia ficar orgulhoso de mim $user??",
                }, 8,
                new String[]{ //Twenty percent
                        "Acho que ta dando errado esse game ($durability durabilidade restante)",
                        "Será que ficar fraco me diz que to ficando pior no jogo, $user? ($durability durabilidade restante)",
                        "Acho que parou de ser izi ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Acho que vou desconectar agora, me desculpe $user ($durability durabilidade restante)",
                        "Até a proxima partida... $user.... ($durability durabilidade restante)",
                        "Será que vou dar respawn? Não quero partir.... ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Lunático",
                new String[]{ //Use
                        "Que isso?",
                        "$user, eu não sei, sabe? serve pra algo?",
                        "Acho que seria útil isso se for útil",
                        "$user! $user! Eu sirvo nesse trabalho no..... O que eu tava falando?",
                        "Olá, $user, qual é o seu nome mesmo? eu não perguntei antes, isso que eu te ajudo",
                },
                24,
                new String[]{ //Kill
                        "Mas será que matou mesmo? tipo, morreu morto",
                        "Espera? EU IA FALAR.... pedra, ahn?",
                        "$user, já pensou se eles voltam e te fazem um bolo?",
                },
                12,
                new String[]{ //Death
                        "UE, por que eu caí no chão???",
                        "$user, ta cansado? deitou do nada no chão, parece até um bloco de grama.",
                },
                new String[]{ //Level Up
                        "To me sentindo diferente, acho que eu fui escolhido! (Level $level)",
                        "Ei $user, vou voar agora? (Level $level)",
                        "Não sabia que eu conseguia..... perai, onde eu to??? (Level $level)",
                },
                new String[]{ //On Hurt
                        "$user eles não são feitos de bolo, sabia?",
                        "LEMBREIIIII..... TANGERINA",
                        "Será que a dor se machuca?",
                        "Tá legal o.... aquilo la.... ahn?, $user? Por que ta batendo nos monstros amiguinhos?",
                        "Se matar um zumbi, ele vai virar um esqueleto?????"
                }, 8,
                new String[]{ //Twenty percent
                        "Acho que a dor ta me batendo ($durability durabilidade restante)",
                        "To mais fraco que.... Oque eu tava falando? quero uma banana. ($durability durabilidade restante)",
                        "SE TER PODER é..... BATATA? ahn?? ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "A DOR TA ME BATENDO SIM..... AAAAaaaaAAAAhH $user!!! ($durability durabilidade restante)",
                        "$user.... Eu queria ter comido uma banana antes de ir.... ($durability durabilidade restante)",
                        "Será que a morte matá?.... ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Raivoso",
                new String[]{ //Use
                        "É ISSO",
                        "$user EU QUERIA TE BATER, MAS NÃO POSSO",
                        "SE UM DIA EU CONSEGUIR SAIR DAQUI, VOU TE USAR COMO VOCÊ ME USA!",
                        "$user! MELHOR AJOELHAR E PEDIR PERDÃO POR ME USAR ASSIM $user! ",
                        "SE ALGO ACONTECER COMIGO $user, VOCÊ VAI JUNTO, NÃO É FACIL FAZER O TRABALHO PESADO",
                },
                24,
                new String[]{ //Kill
                        "CRIATURAS EFÊMERAS!",
                        "$user, O PROXIMO É VOCÊ!",
                        "$user, ELES TIVERAM O QUE MERECERAM POR ME OLHAR",
                },
                12,
                new String[]{ //Death
                        "HAHAHAHA, ISSO, EU DISSE QUE IRIA TE MATAR HAHAHAHA",
                        "$user VOCÊ É UM MERDA, NEM VIVO CONSEGUE FICAR",
                },
                new String[]{ //Level Up
                        "AGORA SERÁ MAIS FACIL TE MATAR $user (Level $level)",
                        "TO TÃO FORTE QUE POSSO DESTRUIR ESSE MUNDO DE MERDA (Level $level)",
                        "CALA A BOCAAAA, MENSAGEM DE LEVEL CHATA (Level $level)",
                },
                new String[]{ //On Hurt
                        "TEM MUITO MAIS DA ONDE SAIU ESSA HAHAHAHA",
                        "IRÁ MORRER DO PIOR JEITO SUA LESMA",
                        "MACHUCA? TADINHO, VAI MORRER PIOR DO QUE A SUA MÃE",
                        "CHAME SEUS AMIGUINHOS PARA MORRER TAMBÉM",
                        "BWAHAHAHAHAHAHA"
                }, 8,
                new String[]{ //Twenty percent
                        "ACHO QUE A MINHA RAIVA ESTA ME CONSUMINDO ($durability durabilidade restante)",
                        "ISSO TUDO É SUA CULPA $user ($durability durabilidade restante)",
                        "SE EU MORRER, IREI VOLTAR PARA TE MATAR SEU BOSTA! ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Acho que a minha raiva me consumiu mesmo..... ($durability durabilidade restante)",
                        "$user.... Eu, eu queria..... me des.... TE MATAR HAHAHAHA ($durability durabilidade restante)",
                        "Morrendo pelo menos eu me livro de um imprestavél igual você $user! ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Nojento",
                new String[]{ //Use
                        "Credoooo!",
                        "$user acho que vou vomitar!",
                        "ISSO! Agora to todo sujo, parabéns!",
                        "AQUILO ERA UMA MINHOCA $user???! ",
                        "*vomitando*",
                },
                24,
                new String[]{ //Kill
                        "CREDOOOOOOO",
                        "$user, VOCÊ ME USOU PARA ESSE TRABALHO SUJO!",
                        "$user, agora quem vai me limpar??? Que nojo",
                },
                12,
                new String[]{ //Death
                        "OTIMO MESMO EM, MORRE E ME DEIXA NO CHÃO SUJO",
                        "$user QUE NOJOOOOOO, to vendo o seu sangue",
                },
                new String[]{ //Level Up
                        "Depois de tanto serviço nojento, acho que essa é a recompensa (Level $level)",
                        "Sera que agora posso trabalhar em um campo de flores? (Level $level)",
                        "EBAAA, agora você vai fazer eu trabalhar mais pesado né? AFF (Level $level)",
                },
                new String[]{ //On Hurt
                        "CREDOOOOOO",
                        "NOJOOOOOOOOOOOOOOOOOOO",
                        "OLHA O SANGUE AAAAAAAAAAAAAAAAAAAA",
                        "PAREEEEEEEEEEE, TA ME SUJANDO",
                        "TIRA ESSA MÃO GORDUROSA DE MIM $user!"
                }, 8,
                new String[]{ //Twenty percent
                        "Acho que to passando mal ($durability durabilidade restante)",
                        "To meio tonto $user ($durability durabilidade restante)",
                        "Eu vi tanto sangue hoje ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Acho.... que to morrendo, que nojo ($durability durabilidade restante)",
                        "$user.... se você tivesse me levado em um lugar melhor...... ($durability durabilidade restante)",
                        "Pelo menos não irei mais ver sangue, nunca mais $user! ($durability durabilidade restante)",
                }));
         createPersonalityFile(new Personality(10, "Negativo",
                new String[]{ //Use
                        "Sabe que não adianta ne?",
                        "$user todos somos perdedores",
                        "EBAA, vamo trabalhar por nada",
                        "Sabe que seu esforço é inutil né $user?! ",
                        "Uma hora ou outra você vai desistir",
                },
                24,
                new String[]{ //Kill
                        "E o que adianta?",
                        "$user parabéns, mas cedo ou tarde você ira morrer",
                        "$user, só esta trabalhando em vão",
                },
                12,
                new String[]{ //Death
                        "Eu disse, não me escutou!",
                        "$user todos iremos perder, eu te disse",
                },
                new String[]{ //Level Up
                        "E o que adianta ficar mais forte? (Level $level)",
                        "Sabe que ainda continuo um inútil né? (Level $level)",
                        "Só me deixe aqui e vá embora (Level $level)",
                },
                new String[]{ //On Hurt
                        "Isso só significa que tera que bater mais",
                        "Todos vamos morrer, não se preocupe",
                        "Ai Ai, é cada trabalho",
                        "$user, seu esforço é uma merda",
                        "Daqui a pouco alguem irá te machucar assim também $user"
                }, 8,
                new String[]{ //Twenty percent
                        "Eu disse.... ($durability durabilidade restante)",
                        "$user sempre tenho razão ($durability durabilidade restante)",
                        "todos somos bosta ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Eu acho.... que vou morrer, finalmente ($durability durabilidade restante)",
                        "$user.... a sua hora será depois ($durability durabilidade restante)",
                        "O Mundo é uma merda..... ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Artista",
                new String[]{ //Use
                        "A arte está em tudo mesmo",
                        "$user será que podemos usar isso para fazer uma obra de arte?",
                        "O mundo se transformando a partir da arte!",
                        "Todos esses pixels! São tão artisticos né $user?! ",
                        "Arte em cada parte desse mundo, é isso que iremos fazer né?",
                },
                24,
                new String[]{ //Kill
                        "Mesmo a morte é uma forma de arte",
                        "$user o sangue restante da pra usar como tinta vermelha, não jogue fora",
                        "$user, que belo artista você é!",
                },
                12,
                new String[]{ //Death
                        "Infelizmente $user, você morreu pela arte",
                        "$user não irei conseguir terminar esse quadro sozinho",
                },
                new String[]{ //Level Up
                        "Queria fazer um desenho desse momento (Level $level)",
                        "A ARTE ESTÁ NO TOPO DO MUNDO (Level $level)",
                        "Eu irei levar a arte pelo mundo agora! (Level $level)",
                },
                new String[]{ //On Hurt
                        "Me desculpe, mas é tudo pela arte.",
                        "A arte sempre vence!",
                        "Sem censura!!!!! #ARTELIVRE",
                        "$user, faça cortes ali também, ta terminando o desenho",
                        "A arte faz parte de você $user"
                }, 8,
                new String[]{ //Twenty percent
                        "A arte..... ($durability durabilidade restante)",
                        "será que to ficando velho para pintar ($durability durabilidade restante)",
                        "$user, continue meus projetos ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "A arte..... Nunca morrerá ($durability durabilidade restante)",
                        "$user.... o palco é todo seu ($durability durabilidade restante)",
                        "Termine meus desenhos.... espalhe eles pelo mundo..... ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Aventureiro",
                new String[]{ //Use
                        "VAMOS EXPLORAR, a gente continua isso depois",
                        "$user não prefere viajar não?",
                        "O mundo está la fora, vamos!!!!!",
                        "Bora procurar uma dungeon $user! ",
                        "Temos tudo que precisamos, vamosssss logo",
                },
                24,
                new String[]{ //Kill
                        "Isso pode ser considerado uma avenura?",
                        "$user falta muitoooo mais do mundo para ver",
                        "$user, o mundo sempre é assim, infelizmente",
                },
                12,
                new String[]{ //Death
                        "NÃOOOOOOOOO, a gente nem foi naquela cavernaaaaaaa",
                        "$user não me deixe parado aquiiiiiii",
                },
                new String[]{ //Level Up
                        "Agora sou um aventureiro mais forte (Level $level)",
                        "ESTOU PRONTO PARA EXPLORAR (Level $level)",
                        "Nada irá me parar de ver o mundo lá fora (Level $level)",
                },
                new String[]{ //On Hurt
                        "Na aventura, sempre tem sangue",
                        "Temos que nós proteger",
                        "Bem que podiamos ser amigos",
                        "$user, será que não existe outro caminho?",
                        "Eu quero ver se amanhã irei lembrar desse ou de outro momento"
                }, 8,
                new String[]{ //Twenty percent
                        "Eu.... to mais fraco ($durability durabilidade restante)",
                        "A aventura é meu ponto forte, não durabilidade ($durability durabilidade restante)",
                        "$user, será que poderei ir com você na proxima aventura? ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Eu não explorei o mundo como queria.... ($durability durabilidade restante)",
                        "$user.... o que eu fiz de errado?..... ($durability durabilidade restante)",
                        "Só queria fazer parte de uma aventura $user ...... ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Nerd",
                new String[]{ //Use
                        "A altura e a largura não ta batendo na minha conta",
                        "$user será que pode me deixar na universidade depois que me usar?",
                        "Se o conhecimento estivesse aqui....",
                        "já fez suas equações antes de fazer isso $user?",
                        "Tudo se resume a matemática",
                },
                24,
                new String[]{ //Kill
                        "TUDO PELA CIÊNCIA",
                        "$user a vida faz parte da equação",
                        "$user a resposta da sua pergunta é 42.",
                },
                12,
                new String[]{ //Death
                        "Infelizmente virou poeira cosmica",
                        "$user melhor voltar para me buscar, não sei me cuidar sozinho",
                },
                new String[]{ //Level Up
                        "A ciência provou sua eficácia (Level $level)",
                        "Einstein será nada perto de mim (Level $level)",
                        "O poder está na ciênciaaaaa (Level $level)",
                },
                new String[]{ //On Hurt
                        "O corpo aguenta bastante machucados",
                        "Irei anotar esses dados na volta",
                        "Meu amigo biologo me contou sobre isso anos atras",
                        "$user, esta tentando fazer experimentos?",
                        "TUDO PELA CIÊNCIA!"
                }, 8,
                new String[]{ //Twenty percent
                        "Acho que preciso descansar ($durability durabilidade restante)",
                        "Sera que vou conseguir terminar a minha teoria ($durability durabilidade restante)",
                        "$user, não pode me levar em algum hospital? ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Irei partir agora..... ($durability durabilidade restante)",
                        "$user.... termine a minha equação da vida, universo e tudo mais! ($durability durabilidade restante)",
                        "Aprendi muito.... não me arrependo, adeus..... ($durability durabilidade restante)",
                }));
        createPersonalityFile(new Personality(10, "Otaku",
                new String[]{ //Use
                        "Pra que fazer isso? Vamo ver anime",
                        "$user tem coisa melhor do que ficar aqui sabia?",
                        "Se pelo menos eu tivesse uma individualidade....",
                        "Já leu todo One Piece $user?",
                        "Bem que eu podia conseguir usar um jutsu né?",
                },
                24,
                new String[]{ //Kill
                        "Não volte como uma maldição em!",
                        "$user será que Gojou ficaria honrado?",
                        "$user, acho que sou um ninja da folha",
                },
                12,
                new String[]{ //Death
                        "CADE O PODER DO PROTAGONISMO",
                        "$user não me faça escutar musica triste e ver flashback justo agora",
                },
                new String[]{ //Level Up
                        "O abacaxi é enigmático quando dança de biquíni (Level $level)",
                        "O Mundo conhecerá a verdadeira Dor (Sekai ni Itami o) (Level $level)",
                        "AGORA VOU PODER USAR O SMASH (Level $level)",
                },
                new String[]{ //On Hurt
                        "POR FAVOR, NÃO VIRE UM GIGANTE",
                        "'Fazer o que bem entender é digno de quem tem poder.' Tokyo Ghoul",
                        "Pelo menos aqui não tem sangue branco",
                        "$user, imagina se tivessemos um objeto sagrado???",
                        "Só espero que não seja o Ban, a Raposa Imortal!"
                }, 8,
                new String[]{ //Twenty percent
                        "Pensei que fosse um shounen.... ($durability durabilidade restante)",
                        "Será que poderei usar meu modo super sayajin agora? ($durability durabilidade restante)",
                        "$user, acho que perdi algum anime, to mais fraco..... ($durability durabilidade restante)",
                },
                new String[]{ //Five percent
                        "Eu acho que..... meu episodio especial acabou.... ($durability durabilidade restante)",
                        "$user.... termine de ler One Piece por mim, sayonara..... ($durability durabilidade restante)",
                        "'É melhor se machucar do que machucar os outros. Pessoas boas podem ser felizes com isso'.... Tokyo... ($durability durabilidade restante)",
                }));
    }

    public static Personality loadPersonality(File personalityLocation) {
        float useOdds = 50, killOdds = 50, hurtOdds = 50, weight = 50;
        String name = "???";
        ArrayList<String> onUse = new ArrayList<>();
        ArrayList<String> onKill = new ArrayList<>();
        ArrayList<String> onDeath = new ArrayList<>();
        ArrayList<String> onLevelUp = new ArrayList<>();
        ArrayList<String> onHurt = new ArrayList<>();
        ArrayList<String> twentyPercent = new ArrayList<>();
        ArrayList<String> fivePercent = new ArrayList<>();
        String state = "none";
        String line = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(personalityLocation), StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().startsWith("[name]")) {
                    state = "name";
                    continue;
                } else if (line.toLowerCase().startsWith("[weight]")) {
                    state = "weight";
                    continue;
                } else if (line.toLowerCase().startsWith("[use]")) {
                    state = "use";
                    continue;
                } else if (line.toLowerCase().startsWith("[useweight]")) {
                    state = "useweight";
                    continue;
                } else if (line.toLowerCase().startsWith("[kill]")) {
                    state = "kill";
                    continue;
                } else if (line.toLowerCase().startsWith("[killweight]")) {
                    state = "killweight";
                    continue;
                } else if (line.toLowerCase().startsWith("[death]")) {
                    state = "death";
                    continue;
                } else if (line.toLowerCase().startsWith("[levelup]")) {
                    state = "levelup";
                    continue;
                } else if (line.toLowerCase().startsWith("[hurt]")) {
                    state = "hurt";
                    continue;
                } else if (line.toLowerCase().startsWith("[hurtweight]")) {
                    state = "hurtweight";
                    continue;
                } else if (line.toLowerCase().startsWith("[25%durability]")) {
                    state = "25%durability";
                    continue;
                } else if (line.toLowerCase().startsWith("[10%durability]")) {
                    state = "10%durability";
                    continue;
                }
                try {
                    switch (state) {
                        case "name":
                            name = line;
                            break;
                        case "weight":
                            weight = Float.parseFloat(line);
                            break;
                        case "use":
                            onUse.add(line);
                            break;
                        case "useweight":
                            useOdds = Float.parseFloat(line);
                            break;
                        case "kill":
                            onKill.add(line);
                            break;
                        case "killweight":
                            killOdds = Float.parseFloat(line);
                            break;
                        case "death":
                            onDeath.add(line);
                            break;
                        case "levelup":
                            onLevelUp.add(line);
                            break;
                        case "hurt":
                            onHurt.add(line);
                            break;
                        case "hurtweight":
                            hurtOdds = Float.parseFloat(line);
                            break;
                        case "25%durability":
                            twentyPercent.add(line);
                            break;
                        case "10%durability":
                            fivePercent.add(line);
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Personality(weight, name, onUse.toArray(new String[onUse.size()]), (int) useOdds, onKill.toArray(new String[onKill.size()]), (int) killOdds, onDeath.toArray(new String[onDeath.size()]), onLevelUp.toArray(new String[onLevelUp.size()]), onHurt.toArray(new String[onHurt.size()]), (int) hurtOdds, twentyPercent.toArray(new String[twentyPercent.size()]), fivePercent.toArray(new String[fivePercent.size()]));
    }
}
