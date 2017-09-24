package melonslise.weapons;

import melonslise.weapons.common.proxy.AProxyCommon;
import melonslise.weapons.common.tab.CreativeTabWeapons;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Weapons.ID, name = Weapons.NAME, version = Weapons.VERSION, acceptedMinecraftVersions = Weapons.GAMEVERSIONS)
public class Weapons
{
	public static final String ID = "weapons", NAME = "Weapons", VERSION = "2.0", GAMEVERSIONS = "1.12"; // TODO Other versions

	@SidedProxy(serverSide = "melonslise.weapons.server.proxy.ProxyServer", clientSide = "melonslise.weapons.client.proxy.ProxyClient")
	public static AProxyCommon proxy;

	public static CreativeTabs creativeTab = new CreativeTabWeapons();

	@Mod.EventHandler
	public static void preInitialization(FMLPreInitializationEvent event)
	{
	}

	@Mod.EventHandler
	public static void initialization(FMLInitializationEvent event)
	{
	}
}