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
                        "Estou ficando mais fraco, $user. ($durability durability remaining)",
                        "Estou começando a me sentir fraco, $user. ($durability durability remaining)",
                        "Não se esqueça de mim, $user! ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "Eu não me sinto bem... ($durability durability remaining!)",
                        "Não pode ser assim que isso termina, $user! ($durability durability remaining!)",
                        "Ainda não estou pronto para morrer, $user! ($durability durability remaining!)",
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
                        "Estou ficando mais fraco, $user. ($durability durability remaining)",
                        "Estou começando a me sentir fraco, $user. ($durability durability remaining)",
                        "Não se esqueça de mim, $user! ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "Eu não me sinto bem... ($durability durability remaining!)",
                        "Não pode ser assim que isso termina, $user! Queria matar mais ($durability durability remaining!)",
                        "Ainda não estou pronto para morrer, $user! ($durability durability remaining!)",
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
                        "Estou ficando mais fraco, $user. Acho que preciso descansar. ($durability durability remaining)",
                        "Estou começando a me sentir mais fraco, $user. ($durability durability remaining)",
                        "Não se esqueça de mim, $user! ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "O fim finalmente chegou? ($durability durability remaining!)",
                        "É aqui que nos separamos, $user? ($durability durability remaining!)",
                        "Ainda não estou pronto para morrer, $user! ($durability durability remaining!)",
                }));
        createPersonalityFile(new Personality(10, "Depressed",
                new String[]{ //Use
                        "$user, isso pode esperar? eu estou muito exausto.",
                        "Do you really need to use me now, $user?",
                        "...Sigh...",
                        "I just wanna sleep...",
                        "Are we almost done yet, $user? I'm really tired.",
                },
                48,
                new String[]{ //Kill
                        "They're better off now anyway, $user",
                        "It's unfortunate I can't get you to kill me instead, $user",
                        "...Lucky",
                        "If only..."
                },
                22,
                new String[]{ //Death
                        "No $user, Not you too!",
                        "Don't leave me here, $user! Take me with you!",
                        "You're lucky, $user...",
                        "$user, I wish I was you... If I only was so fortunate"
                },
                new String[]{ //Level Up
                        "$user, I feel a bit better ($level)",
                        "Hey, $user, I'm starting to feel better... nope, wait, I'm not. ($level)",
                        "I don't deserve this, $user ($level)",
                        "Why help me, $user? ($level)",
                        "$user, just stop. I don't need your sympathy ($level).",
                },
                new String[]{ //On Hurt
                        "That's not very nice of you, $user...",
                        "Maybe you shouldn't hurt others, $user...",
                        "$user, is that really nice of you?",
                        "$user, when will you stop swinging me around? I'm tired.",
                },
                18,
                new String[]{ //Twenty percent
                        "My weakness is growing, $user. ($durability durability remaining)",
                        "I'm starting to feel weaker, $user. ($durability durability remaining)",
                        "Don't forget about me, $user! ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "Is the end finally here? ($durability durability remaining!)",
                        "Is this where we part ways, $user? ($durability durability remaining!)",
                        "I'm ready, $user... ($durability durability remaining!)",
                }));
        createPersonalityFile(new Personality(10, "Demonic",
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
                        "$user, ao bnzl zegsl ni jlmgbo dlwblhld! ($durability durability remaining)",
                        "Oep apih jeh zegvlh he rlmb al, $user! ($durability durability remaining)",
                        "Ao lmcjlii vgei... ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "Oep mjh hrmh n irepbd wlgnir, $user? ($durability durability remaining!)",
                        "Ro ej'h oep rlbw al, $user? ($durability durability remaining!)",
                        "N ma jlmgbo dlihgeold, $user! ($durability durability remaining!)",
                }));
        createPersonalityFile(new Personality(10, "Silent",
                new String[]{ //Use
                        "..."
                },
                40,
                new String[]{ //Kill
                        "..."
                },
                40,
                new String[]{ //Death
                        "..."
                },
                new String[]{ //Level Up
                        "... (Level $level)"
                },
                new String[]{ //On Hurt
                        "..."
                },
                40,
                new String[]{ //Twenty percent
                        "... ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "... ($durability durability remaining)",
                }));
        createPersonalityFile(new Personality(10, "Cat",
                new String[]{ //Use
                        "Meow.",
                        "Meeoow.",
                        "Meew.",
                        "Hiss!",
                        "Meow?"
                },
                24,
                new String[]{ //Kill
                        "Meow!",
                        "Hiss!",
                        "Hisss!",
                },
                12,
                new String[]{ //Death
                        "Meow...",
                        "Meow... meow?",
                        "Meow...?"
                },
                new String[]{ //Level Up
                        "Meow! (Level $level)"
                },
                new String[]{ //On Hurt
                        "Meow!",
                        "Hiss!",
                        "Hiss!",
                        "Hisss!"
                }, 8,
                new String[]{ //Twenty percent
                        "Meow! ($durability durability remaining)",
                        "Meow? ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "Growl! ($durability durability remaining)",
                        "Meow! ($durability durability remaining)",
                        "Meow??? Bark Bark! ($durability durability remaining)",
                }));
        createPersonalityFile(new Personality(10, "Dog",
                new String[]{ //Use
                        "Woof.",
                        "Howl.",
                        "Whimper.",
                        "Bark! Bark! Bark!",
                        "*Sniffs*"
                },
                24,
                new String[]{ //Kill
                        "Bark!",
                        "Bark bark bark!",
                        "Bark! Bark! Bark!"
                },
                12,
                new String[]{ //Death
                        "Whimper.",
                        "Whine.",
                },
                new String[]{ //Level Up
                        "Bark! (Level $level)",
                        "Woof! (Level $level)"
                },
                new String[]{ //On Hurt
                        "Woof!",
                        "Bark!",
                        "Bark bark bark!",
                        "Howl.",
                        "Low growl."
                }, 8,
                new String[]{ //Twenty percent
                        "Wimpers. ($durability durability remaining)",
                        "Whine. ($durability durability remaining)",
                        "Bark! Bark Bark! ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "Wimpers. ($durability durability remaining)",
                        "Whine. ($durability durability remaining)",
                        "Bark! Bark Bark! ($durability durability remaining)",
                }));
        createPersonalityFile(new Personality(10, "Glitchy",
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
                        "§km a displacement kinetic energy of the resultant x? We caus§r ($durability durability remaining)",
                        "§kin call product of a particle o§r ($durability durability remaining)",
                        "§k then stant and V - ½ ( ½ ( V is the represe§r ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "§kd the squationstant x? We mas§r ($durability durability remaining!)",
                        "§krticle of the resent acti§r ($durability durability remaining!)",
                        "§k stant and V - ½ ( ½ ( V is the represent kineticle on a partic energy of its speed at t§r ($durability durability remaining!)",
                }));
        createPersonalityFile(new Personality(10, "Alien",
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
                        "⋔⊬ ⌰⟟⎎⟒ ⟒⌇⌇⟒⋏☊⟒ ⟟⌇ ☌⟒⏁⏁⟟⋏☌ ⎎⏃⟟⍀⌰⊬ ⌰⍜⍙... ($durability durability remaining)",
                        "⟟⌇⋏'⏁ ⟟⏁ ⏁⟟⋔⟒ ⊬⍜⎍ ⍀⟒⌿⏃⟟⍀⟒⎅ ⋔⟒? ($durability durability remaining)",
                        "⟟'⋔ ⎎⟒⟒⌰⟟⋏☌ ⌿⍀⟒⏁⏁⊬ ⍙⟒⏃☍ ($durability durability remaining)",
                },
                new String[]{ //Five percent
                        "⋔⊬ ⌰⟟⎎⟒ ⟒⌇⌇⟒⋏☊⟒ ⟟⌇ ☌⟒⏁⏁⟟⋏☌ ⎎⏃⟟⍀⌰⊬ ⌰⍜⍙... ($durability durability remaining!)",
                        "⟟⌇⋏'⏁ ⟟⏁ ⏁⟟⋔⟒ ⊬⍜⎍ ⍀⟒⌿⏃⟟⍀⟒⎅ ⋔⟒? ($durability durability remaining!)",
                        "⟟'⋔ ⎎⟒⟒⌰⟟⋏☌ ⌿⍀⟒⏁⏁⊬ ⍙⟒⏃☍ ($durability durability remaining!)",
                }));
        createPersonalityFile(new Personality(10, "Energetic",
                new String[]{ //Use
                        "Again! Again!",
                        "This is so fun, let's keep doing it, $user!",
                        "Keep going!",
                        "Yay!",
                        "I could do this all day!",
                        "$user, don't stop! This is so much fun!",
                        "I want more!",
                        "This is exciting! Don't you agree, $user?"
                },
                24,
                new String[]{ //Kill
                        "We really showed them!",
                        "Good job, $user!",
                        "Killing is so much work! I love it!"
                },
                12,
                new String[]{ //Death
                        "Oh no! Is this the end?",
                        "Noooo! We were only getting started!",
                        "We'll get them next time, right? $user? ...oh, you died.",
                        "Don't forget about me, $user!"
                },
                new String[]{ //Level Up
                        "Ah yes, more power! (Level $level)",
                        "I can feel the power flowing through me, $user! Let's keep going! (Level $level)",
                        "I feel stronger already, $user! (Level $level)!"
                },
                new String[]{ //On Hurt
                        "Ouch! I bet they'll feel that one tomorrow, $user!",
                        "Ooo, that looks like it had to hurt!",
                        "Ouch!",
                        "Take that!"
                },
                16,
                new String[]{ //Twenty percent
                        "I'm starting to hurt, $user. ($durability durability remaining)",
                        "I'm feeling weaker, $user. ($durability durability remaining)",
                        "Don't forget about me, $user! ($durability durability remaining)"
                },
                new String[]{ //Five percent
                        "(oof...) Is... is this the end of our adventure, $user? ($durability durability remaining!)",
                        "I don't feel so good, $user... ($durability durability remaining!)",
                        "I don't wanna die, $user! ($durability durability remaining!)",
                        "I guess... this is it, huh $user? ($durability durability remaining!)"
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
