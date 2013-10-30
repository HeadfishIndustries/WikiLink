package co.einsteinium.wikilink.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.link.Link;
import co.einsteinium.wikilink.link.LinkGoogle;
import co.einsteinium.wikilink.link.LinkWiki;
import co.einsteinium.wikilink.link.LinkYoutube;
import co.einsteinium.wikilink.plg.PluginRegistry;
import co.einsteinium.wikilink.util.BrowserHandler;

public class GuiContainerWikiLinkMenu extends GuiContainer
{
	public GuiContainerWikiLinkMenu(InventoryWikiLinkMenu par1, ItemStack item) 
	{
		super(new ContainerWikiLinkMenu(par1, item));
		
		if(item != null)
		{
			//if(PluginRegistry.getWikiDisplayMap().containsKey(Link.getItemIdModId(item.itemID)))
			//{
				LinkWiki wikilink = new LinkWiki(item);
			//}
			
			if(PluginRegistry.getGoogleDomainMap().containsKey(Link.getItemIdModId(item.itemID)))
			{
				LinkGoogle link = new LinkGoogle(item);
			}
			
			if(PluginRegistry.getItemSpotlightMap().containsKey(item.itemID))
			{
				LinkYoutube link = new LinkYoutube(item);
			}
		}
	}
	
	private String hyperlink = new String();
	
	public static FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
	private static final TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
	private static final ResourceLocation textureLocation = new ResourceLocation("wikilink:gui/menu.png");

	public int x = 0; 
	public int y = 0;
	public int z = 0;	
	
	public final int xSizeOfTexture = 176;
	public final int ySizeOfTexture = 154;
	
	protected void keyTyped(char par1, int par2)
	{
		if(par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
		{
			this.mc.thePlayer.closeScreen();
		}
	}
	
	public boolean doesGuiPauseGame()
	{			
		return false;
	}
	
	public void initGui()
	{
		super.initGui();
		
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		//Link.buildGui();
		
		for(int i = 0; i <= 5; i++)
		{
			if(!Link.getDisplayListIndex(i).isEmpty() && Link.getDisplayListIndex(i) != null)	
			{	
				buttonList.add(new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getDisplayListIndex(i), true));
			}
				
		}
			buttonList.add(new GuiButton(6, posX + 6, posY + 129, 72, 20, "Browser"));
			buttonList.add(new GuiButton(7, posX + 79, posY + 129, 72, 20, "Clipboard"));
	}

	public void setHyperlink(String h)
	{
		hyperlink = h;
	}
	public String getHyperlink()
	{
		return hyperlink;
	}
	
	protected void actionPerformed(GuiButton button)
	{		
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		switch(button.id)
		{			
			case 0:
			{
				button.enabled = false;
				
				for(int i = 0; i < 5; i++)
				{
					if(!Link.getDisplayListIndex(i).isEmpty() && i != button.id)	
					{
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getDisplayListIndex(i), true));		
					}
				}
				
				setHyperlink(Link.getDomainListIndex(button.id));
				
				break;
			}
			case 1:
			{				
				button.enabled = false;
				
				for(int i = 0; i < 5; i++)
				{
					if(!Link.getDisplayListIndex(i).isEmpty() && i != button.id)	
					{
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getDisplayListIndex(i), true));		
					}
				}				
				
				setHyperlink(Link.getDomainListIndex(button.id));				

				break;
			}
			case 2:
			{
				button.enabled = false;
				
				for(int i = 0; i < 5; i++)
				{
					if(!Link.getDisplayListIndex(i).isEmpty() && i != button.id)	
					{
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getDisplayListIndex(i), true));		
					}
				}
				
				setHyperlink(Link.getDomainListIndex(button.id));
				
				break;
			}
			case 3:
			{
				button.enabled = false;
				
				for(int i = 0; i < 5; i++)
				{
					if(!Link.getDisplayListIndex(i).isEmpty() && i != button.id)	
					{
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getDisplayListIndex(i), true));		
					}
				}
				
				setHyperlink(Link.getDomainListIndex(button.id));
				
				break;
			}
			case 4:
			{
				button.enabled = false;
				
				for(int i = 0; i < 5; i++)
				{
					if(!Link.getDisplayListIndex(i).isEmpty() && i != button.id)	
					{
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getDisplayListIndex(i), true));		
					}
				}
				
				setHyperlink(Link.getDomainListIndex(button.id));
				
				break;
			}
			case 5:
			{
				button.enabled = false;
				
				for(int i = 0; i < 5; i++)
				{
					if(!Link.getDisplayListIndex(i).isEmpty() && i != button.id)	
					{
						buttonList.set(i, new GuiWikiLinkButton(i, posX + 7, posY + 6 + (20 * i), 162, 20, Link.getDisplayListIndex(i), true));		
					}
				}
				
				setHyperlink(Link.getDomainListIndex(button.id));
				
				break;
			}
			// Buttons
			case 6:
			{
				if(!getHyperlink().isEmpty())
				{
					if(!getHyperlink().contains("404Error"))
					{
						BrowserHandler.browserInit(getHyperlink());
					}
					else
					{
						Minecraft.getMinecraft().thePlayer.closeScreen();
						Minecraft.getMinecraft().thePlayer.addChatMessage("\u00A76[\u00A7aWikiLink\u00A76]\u00A74 404 Error - WikiLink does not exist. Please contact \u00A79@DrEinsteinium \u00A74with the information below.");
						Minecraft.getMinecraft().thePlayer.addChatMessage(LinkWiki.getErrorMessage());
					}
				}
				break;
			}
			case 7:
			{
				if(!getHyperlink().isEmpty())
				{
					if(!getHyperlink().contains("404Error"))
					{
						StringSelection selection = new StringSelection(getHyperlink());
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(selection, selection);
						
						Minecraft.getMinecraft().thePlayer.closeScreen();
						Minecraft.getMinecraft().thePlayer.addChatMessage("\u00A76[\u00A7aWikiLink\u00A76]\u00A74 404 The WikiLink has been copied to the clipboard.");	
					}
					else
					{
						Minecraft.getMinecraft().thePlayer.closeScreen();
						Minecraft.getMinecraft().thePlayer.addChatMessage("\u00A76[\u00A7aWikiLink\u00A76]\u00A74 404 Error - WikiLink does not exist. Please contact \u00A79@DrEinsteinium \u00A74with the information below.");
						Minecraft.getMinecraft().thePlayer.addChatMessage(LinkWiki.getErrorMessage());
					}
				}
				
				break;
			}	
		}
	}
	
/*	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
	{
		super.mouseClicked(mouseX,  mouseY,  mouseButton);
		
		for(GuiButton button : (List<GuiButton>) buttonList)
		{
			if(button.mousePressed(mc, mouseX, mouseY))
			{
				mc.sndManager.playSoundFX("random.click", 1, 1);
				actionPerformed(button);
			}
		}
	}*/

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation);
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		
		RenderItem renderer = new RenderItem();
		
		 GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		 
	        RenderHelper.disableStandardItemLighting();
	        GL11.glDisable(GL11.GL_LIGHTING);
	        
	        RenderHelper.enableGUIStandardItemLighting();
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	        
	        short shorta = 240;
	        short shortb = 240;
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, shorta / 1.0F, shortb / 1.0F);

		renderer.renderItemAndEffectIntoGUI(fontRenderer, renderEngine, Link.getItemStack(), posX + 153, posY + 131);
	}
}
